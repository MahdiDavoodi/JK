package ir.blog.mahdidavoodi;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Purchase {
    protected static class Receipt {
        UserManagement.User user;
        public ArrayList<Store.Product> purchaseList;
    }

    public Purchase() {
        loadReceiptsData("ReceiptsData.json");
    }

    protected Receipt receipt = new Receipt();
    public ArrayList<Receipt> receipts = new ArrayList<>();
    public ArrayList<Store.Product> cart = new ArrayList<>();

    protected void saveReceiptsData(String pathname) {
        try {
            FileWriter writer = new FileWriter(pathname);
            JSONArray receiptsList = new JSONArray();
            for (Receipt receipt :
                    receipts) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("email", receipt.user.getEmail());
                for (Store.Product product :
                        receipt.purchaseList) {
                    jsonObject.put("name", product.getName());
                    jsonObject.put("price", product.getPrice());
                }
                receiptsList.add(jsonObject);
            }
            writer.write(receiptsList.toJSONString());
            writer.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    protected void loadReceiptsData(String pathname) {
        try {
            FileReader reader = new FileReader(pathname);
            JSONParser jsonParser = new JSONParser();
            JSONArray usersList = (JSONArray) jsonParser.parse(reader);
            usersList.forEach(item -> {
                JSONObject jsonObject = (JSONObject) item;
                Receipt receipt = new Receipt();
                receipt.user.setEmail(jsonObject.get("email").toString());
                for (Store.Product product :
                        receipt.purchaseList) {
                    product.setName(jsonObject.get("name").toString());
                    product.setPrice(Integer.parseInt(jsonObject.get("price").toString()));
                }
                receipts.add(receipt);
            });
        } catch (ParseException | IOException exception) {
            exception.printStackTrace();
        }
    }

    protected boolean newPurchase() {
        if (cart.size() > 0) {
            for (UserManagement.User user :
                    UserManagement.users) {
                if (UserManagement.currentUserEmail.equalsIgnoreCase(user.getEmail())) {
                    receipt.user = user;
                    receipt.purchaseList = cart;
                    return true;
                }
            }
        }
        return false;


    }

    protected void showPurchaseList() {
        int counter = 1;
        for (Store.Product product :
                cart) {
            System.out.println(counter + ". " + product.getName() + " \t " + product.getPrice());
        }
    }

    protected void addProductToCart() {
        for (Store.Product product :
                Store.products) {
            if (Store.currentProductId == product.getId()) {
                Store.reduceProduct(1);
                UserManagement.editWalletBalance(-1 * product.getPrice());
                cart.add(product);
            }
        }
    }
}
