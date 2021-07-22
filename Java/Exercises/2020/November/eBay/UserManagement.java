package ir.blog.mahdidavoodi;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UserManagement {
    protected static class User {
        private String email;
        private long password;
        private String name;
        private int walletBalance;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public long getPassword() {
            return password;
        }

        public void setPassword(long password) {
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getWalletBalance() {
            return walletBalance;
        }

        public void setWalletBalance(int walletBalance) {
            this.walletBalance = walletBalance;
        }
    }

    public UserManagement() {
        loadUsersData("UsersData.json");
    }

    protected static ArrayList<User> users = new ArrayList<>();
    protected static boolean userLoggedIn = false;
    protected static String currentUserEmail = "";

    protected void loadUsersData(String pathname) {
        try {
            FileReader reader = new FileReader(pathname);
            JSONParser jsonParser = new JSONParser();
            JSONArray usersList = (JSONArray) jsonParser.parse(reader);
            usersList.forEach(item -> {
                JSONObject jsonObject = (JSONObject) item;
                User user = new User();
                user.setEmail(jsonObject.get("email").toString());
                user.setName(jsonObject.get("name").toString());
                user.setPassword(Long.parseLong(jsonObject.get("password").toString()));
                user.setWalletBalance(Integer.parseInt(jsonObject.get("walletBalance").toString()));
                users.add(user);
            });
        } catch (ParseException | IOException exception) {
            exception.printStackTrace();
        }
    }

    protected void saveUsersData(String pathname) {
        try {
            FileWriter writer = new FileWriter(pathname);
            JSONArray usersList = new JSONArray();
            for (User user :
                    users) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("email", user.getEmail());
                jsonObject.put("name", user.getName());
                jsonObject.put("password", user.getPassword());
                jsonObject.put("walletBalance", user.getWalletBalance());


                usersList.add(jsonObject);
            }
            writer.write(usersList.toJSONString());
            writer.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    protected boolean loginUser(String email, String password) {
        for (User user :
                users) {
            if (user.getEmail().equalsIgnoreCase(email))
                if (user.getPassword() == passwordHash(password)) {
                    currentUserEmail = user.getEmail();
                    userLoggedIn = true;
                    return true;
                }
        }
        return false;
    }

    protected boolean createUser(String email, String password, String name, int walletBalance) {
        for (User user :
                users) {
            if (user.getEmail().equalsIgnoreCase(email)) return false;
        }
        if (emailChecker(email)) {
            User newUser = new User();
            newUser.setEmail(email);
            newUser.setPassword(passwordHash(password));
            newUser.setName(name);
            newUser.setWalletBalance(walletBalance);
            users.add(newUser);
            return true;
        }
        return false;
    }

    protected boolean removeUser() {
        if (userLoggedIn) {
            users.removeIf(user -> user.getEmail().equalsIgnoreCase(currentUserEmail));
            userLoggedIn = false;
            return true;
        }
        return false;
    }

    protected static int editWalletBalance(int difference) {
        if (userLoggedIn) {
            for (User user :
                    users) {
                if (user.getEmail().equalsIgnoreCase(currentUserEmail)) {
                    user.setWalletBalance(user.getWalletBalance() + difference);
                    return user.getWalletBalance();
                }
            }
        }
        return 0;
    }

    protected long passwordHash(String password) {
        long passwordHash = 1;
        for (int i = 0; i < password.length(); i++) {
            passwordHash = (passwordHash * 255 + password.charAt(i)) % 1000000;
        }
        return passwordHash;
    }

    protected boolean emailChecker(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

}
