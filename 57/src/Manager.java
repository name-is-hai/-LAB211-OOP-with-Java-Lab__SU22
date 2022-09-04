
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
public class Manager {

    public void createNewAcc(ArrayList<User> users) {
        System.out.print("Enter Username: ");
        String userName = inputUserName();
        if (!checkUserExist(users, userName)) {
            System.out.println("User name have been exist.");
            return;
        }
        System.out.print("Enter Password: ");
        String pass = inputPassword();

        users.add(new User(userName, pass));
        System.out.println("Add success!");
    }

    public void login(ArrayList<User> users) {
        if (users.isEmpty()) {
            System.err.println("Account empty.");
            return;
        }
        System.out.print("Enter Username: ");
        String username = inputUserName();
        System.out.print("Enter Password: ");
        String password = inputPassword();
        User user = getUser(users, username, password);
        if (user == null) {
            System.err.println("Invalid username or password.");
            return;
        }else{
            System.out.println("Login successfull!");
        }
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

    public String inputUserName() {
        Scanner sc = new Scanner(System.in);
        //loop until user enter corrcect
        while (true) {
            String name = sc.nextLine();
            if (name.isEmpty()) {
                System.out.println("Input not be blank.");
                System.out.println("Please re-enter:");
            } else {
                if (!name.matches("^\\S{5}\\S*$")) {
                    System.out.println("You must enter least at 5 character, and no space!");
                    System.out.println("Please re-enter:");
                } else {
                    return name;
                }
            }
        }
    }

    public String inputPassword() {
        Scanner sc = new Scanner(System.in);
        //loop until user enter corrcect
        while (true) {
            String pass = sc.nextLine();
            if (pass.isEmpty()) {
                System.out.println("Input not be blank.");
                System.out.println("Please re-enter:");
            } else {
                if (!pass.matches("^\\S{6}\\S*$")) {
                    System.out.println("You must enter least at 6 character, and no space!");
                    System.out.println("Please re-enter:");
                } else {
                    return pass;
                }
            }
        }
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
