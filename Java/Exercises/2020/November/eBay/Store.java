package ir.blog.mahdidavoodi;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Store {
    protected static class Product {

        private long id;
        private String name;
        private int price;
        private int number;
        private String companyName;
        private String supplier;
        private String category;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getSupplier() {
            return supplier;
        }

        public void setSupplier(String supplier) {
            this.supplier = supplier;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }
    }

    public Store() {
        loadProductsData("ProductsData.json");
    }

    protected static ArrayList<Product> products = new ArrayList<>();
    protected static long currentProductId;

    protected void loadProductsData(String pathname) {
        try {
            FileReader reader = new FileReader(pathname);
            JSONParser jsonParser = new JSONParser();
            JSONArray usersList = (JSONArray) jsonParser.parse(reader);
            usersList.forEach(item -> {
                JSONObject jsonObject = (JSONObject) item;
                Product product = new Product();
                product.setId(Long.parseLong(jsonObject.get("id").toString()));
                product.setCategory(jsonObject.get("category").toString());
                product.setName(jsonObject.get("name").toString());
                product.setCompanyName(jsonObject.get("companyName").toString());
                product.setPrice(Integer.parseInt(jsonObject.get("price").toString()));
                product.setNumber(Integer.parseInt(jsonObject.get("number").toString()));
                product.setSupplier(jsonObject.get("supplier").toString());
                products.add(product);
            });
        } catch (ParseException | IOException exception) {
            exception.printStackTrace();
        }
    }

    protected void saveProductsData(String pathname) {
        try {
            FileWriter writer = new FileWriter(pathname);
            JSONArray productsList = new JSONArray();
            for (Product product :
                    products) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", product.getId());
                jsonObject.put("category", product.getCategory());
                jsonObject.put("name", product.getName());
                jsonObject.put("companyName", product.getCompanyName());
                jsonObject.put("price", product.getPrice());
                jsonObject.put("number", product.getNumber());
                jsonObject.put("supplier", product.getSupplier());

                productsList.add(jsonObject);
            }
            writer.write(productsList.toJSONString());
            writer.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    protected static int reduceProduct(int number) {
        for (Product product :
                products) {
            if (product.getId() == currentProductId) {
                if (product.getNumber() > number) {
                    product.setNumber(product.getNumber() - number);
                    return product.getNumber();
                } else if (product.getNumber() == number) {
                    removeProduct();
                    return 0;
                } else System.out.println("---> You are trying to order out of number!");
            }
        }
        return -1;
    }

    private static void removeProduct() {
        products.removeIf(product -> product.getId() == currentProductId);
    }

    protected boolean addProduct(int number) {
        for (Product product :
                products) {
            if (product.getId() == currentProductId) {
                if (number > 0) {
                    product.setNumber(product.getNumber() + number);
                    return true;
                } else System.out.println("---> You can not reduce this product!");
            }
        }
        return false;
    }

    protected void showProductMenu() {
        int counter = 1;
        for (Product product :
                products) {
            System.out.println(counter + ". " + product.getName());
            counter++;
        }
    }

    protected boolean selectProducts(int numberInMenu) {
        if (numberInMenu > 0 && numberInMenu <= products.size()) {
            Product product = products.get(numberInMenu - 1);
            for (UserManagement.User user :
                    UserManagement.users) {
                if (user.getEmail().equalsIgnoreCase(UserManagement.currentUserEmail)) {
                    if (user.getWalletBalance() > product.getPrice()) {
                        currentProductId = product.getId();
                        return true;
                    }
                }
            }
        }

        return false;
    }

    protected boolean newProduct(long id, String name, int price, int number, String companyName, String supplier, String category) {
        for (Product product :
                products) {
            if (product.getId() == id) {
                if (number > 0) {
                    product.setNumber(number);
                    return false;
                }
            }
        }
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setNumber(number);
        product.setCompanyName(companyName);
        product.setSupplier(supplier);
        product.setCategory(category);
        products.add(product);
        return true;
    }

}
