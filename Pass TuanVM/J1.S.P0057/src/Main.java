
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        Menu menu = new Menu();
        Data data = new Data();
        //Step1 : create file name
        String fileName = "user.dat";
        //Step2 : input DB
        ArrayList<User> users = data.inputDB(fileName);
        while (true) {
            int choice = menu.getChoice(1, 3);
            switch (choice) {
                //user choice 1
                case 1:
                    //add new acc
                    addUser(users);
                    //save into DB
                    data.saveDB(users, fileName);
                    break;
                //user choice 2
                case 2:
                    //login 
                    login(users);
                    break;
                case 3:
                    return;
            }
        }
    }

    public static String inputPass() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String name = sc.nextLine();
            // input can not be blank
            if (name.isEmpty()) {
                System.out.println("Input not be blank.");
                System.out.println("Please re-enter:");
            } else {
                //Username must be at least 5 characters and no spaces 
                if (name.length() < 5 && name.matches("^\\S{6}\\S*$")) {
                    System.out.println("Username must be at least 6 characters and no spaces");
                    System.out.println("Please re-enter:");
                } else {
                    return name;
                }
            }
        }
    }

    public static String inputUserName() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String pass = sc.nextLine();
            //// input can not be blank
            if (pass.isEmpty()) {
                System.out.println("Input not be blank.");
                System.out.println("Please re-enter:");
            } else {
                //Password must be at least 6 characters and no spaces.
                if (pass.length() < 6 && pass.matches("^\\S{5}\\S*$")) {
                    System.out.println("Username must be at least 5 characters and no spaces");
                    System.out.println("Please re-enter:");
                } else {
                    return pass;
                }
            }
        }
    }

    public static User getUser(ArrayList<User> users, String acc, String pass) {
        // reach each user in DB
        for (int i = 0; i < users.size(); i++) {
            //find out that user have same acc
            if (acc.equalsIgnoreCase(users.get(i).getUsername())) {
                //find out that user have same pass 
                if (pass.equalsIgnoreCase(users.get(i).getPassword())) {
                    return users.get(i);
                }
            }
        }
        return null;

    }

    public static boolean checkUserExist(ArrayList<User> users, String acc) {
        // reach each user in DB
        for (User user : users) {
            String userName = user.getUsername();
            //find out user name
            if (userName.equalsIgnoreCase(acc)) {
                return false;
            }
        }
        return true;
    }

    private static void login(ArrayList<User> users) {
        System.out.print("Account: ");
        String username = inputUserName();
        System.out.print("Password: ");
        String password = inputPass();
        User user = getUser(users, username, password);
        //can not find account have that acc and pass
        if (user == null) {
            System.err.println("Invalid username or password.");
            return;
        } else {
            System.out.println("Login successful.");
        }
    }

    private static void addUser(ArrayList<User> users) {
        System.out.print("Enter Username:");
        String acc = inputUserName();
        //user name have exist
        if (!checkUserExist(users, acc)) {
            System.out.println("User name have been exist.");
            return;
        }
        System.out.print("Enter Password:");
        String pass = inputPass();
        
        users.add(new User(acc, pass));
        System.out.println("Add successful.");
    }
}
