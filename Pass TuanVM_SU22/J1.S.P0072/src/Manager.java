

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author ADMIN
 */
public class Manager {

    public void addUser(ArrayList<User> users) {
        System.out.print("Account:");
        String acc = inputUsername();
        if (!checkUserExist(users, acc)) {
            System.out.println("User name have been exist.");
            return;
        }
        System.out.print("Password:");
        String pass = inputPassword();
        System.out.print("Name:");
        String name = inputName();
        System.out.print("Phone:");
        String phone = inputPhone();
        System.out.print("Email:");
        String email = inputEmail();
        System.out.print("Address:");
        String address = inputAddress();
        System.out.print("DOB:");
        Date dob = inputDate();

        users.add(new User(acc, pass, name, phone, email, address, dob));
        System.err.println("Add susseces");
    }

    public String inputAddress() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String name = sc.nextLine();
            if (name.isEmpty()) {
                System.out.println("Input not be blank.");
                System.out.println("Please re-enter:");
            } else {
                return name;
            }
        }
    }

    public Date inputDate() {
        Scanner sc = new Scanner(System.in);
        while (true) {

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            format.setLenient(false);
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Input can not be empty");
                System.err.println("Re-input:");
                continue;
            } else if (!result.matches("\\d{1,2}[/]\\d{1,2}[/]\\d{4}")) {
                System.out.println("Input wrong format dd/MM/yyyy");
                System.err.println("Re-input:");
                continue;
            }
            try {
                Date date = format.parse(result);
                Date now = new Date();
                if (date.after(now)) {
                    System.out.println("Date can not be in the future");
                    System.err.println("Re-input:");
                    continue;
                }
                return date;
            } catch (Exception ex) {
                System.out.println("Date is not exist");
            }
        }
    }

    public String inputEmail() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String result = sc.nextLine().trim();
            if (result.length() != 0 && result.matches("^[0-9A-Za-z+_.%]+@[0-9A-Za-z.-]+\\.[A-Za-z]{2,4}$")) {
                return result;
            } else {
                System.err.println("Re-input");
            }
        }
    }

    public String inputPhone() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String result = sc.nextLine().trim();
            if (result.length() != 0 && result.matches("^\\d{9,10}$")) {
                return result;
            } else {
                System.err.println("Re-input");
            }
        }
    }

    public String inputName() {
        Scanner sc = new Scanner(System.in);
        //loop until user enter corrcect
        while (true) {
            String name = sc.nextLine();
            if (name.isEmpty()) {
                System.out.println("Input not be blank.");
                System.out.println("Please re-enter:");
            } else {
                if (!name.matches("^[a-z A-Z]*$")) {
                    System.out.println("Name enter only letter.");
                    System.out.println("Please re-enter:");
                } else {
                    return name;
                }
            }
        }
    }

    public String inputPassword() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String name = sc.nextLine();
            if (name.isEmpty()) {
                System.out.println("Input not be blank.");
                System.out.println("Please re-enter:");
            } else {
                return MD5Encryption(name);
            }
        }
    }

    public String inputUsername() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String name = sc.nextLine();
            if (name.isEmpty()) {
                System.out.println("Input not be blank.");
                System.out.println("Please re-enter:");
            } else {
                return name;
            }
        }
    }

    public String MD5Encryption(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            return DatatypeConverter.printHexBinary(md.digest()).toLowerCase();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return null;

    }

    public void login(ArrayList<User> users) {
        if (users.isEmpty()) {
            System.err.println("Accout empty.");
            return;
        }
        System.out.print("Enter username: ");
        String username = inputUsername();
        System.out.print("Enter Password: ");
        String password = inputPassword();
        User user = getUser(users, username, password);
        if (user == null) {
            System.err.println("Invalid username or password.");
            return;
        } else {
            System.out.println("-------- Wellcome -------");
            {
                System.out.println("Hi " + user.getName() + ", do you want to change password now? Y/N");
                String choice = getChoice();
                if (choice.equalsIgnoreCase("Y")) {
                    updatePass(user);
                }
                if (choice.equalsIgnoreCase("N")) {
                    return;
                }
            }
        }
    }

    public String getChoice() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String choice = sc.nextLine();
            if (choice.isEmpty()) {
                System.out.println("Input not be blank.");
                System.out.println("Please re-enter:");
            } else {
                if (!choice.equalsIgnoreCase("Y") || !choice.equalsIgnoreCase("N")) {
                    System.out.println("Please choice Y or N");
                }
                return choice;
            }
        }
    }

    public void updatePass(User user) {
        String userPass = user.getPassword();

        System.out.print("Old password: ");
        String oldPassword = inputPassword();


        if (oldPassword.equalsIgnoreCase(userPass)) {
            System.out.println("Old Password not correct.");
            return;
        }

        System.out.print("New password: ");
        String newPassword = inputPassword();


        if (newPassword.equalsIgnoreCase(oldPassword)) {
            System.out.println("New Password and Old Password can not be the same.");
            return;
        }

        System.out.print("Renew password: ");
        String renewPassword = inputPassword();
        if (!renewPassword.equalsIgnoreCase(newPassword)) {
            System.out.println("RenewPassword and NewPassword not the same.");
            return;
        }

        user.setPassword(newPassword);
        System.out.println("Change password success.");
    }

    public User getUser(ArrayList<User> users, String acc, String pass) {
        for (int i = 0; i < users.size(); i++) {
            if (acc.equalsIgnoreCase(users.get(i).getUsername())) {
                if (pass.equalsIgnoreCase(users.get(i).getPassword())) {
                    return users.get(i);
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    public boolean checkUserExist(ArrayList<User> users, String acc) {
        for (User user : users) {
            String userName = user.getUsername();
            if (userName.equalsIgnoreCase(acc)) {
                return false;
            }
        }
        return true;
    }
}
