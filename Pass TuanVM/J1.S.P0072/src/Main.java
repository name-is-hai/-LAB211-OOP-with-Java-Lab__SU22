
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Menu menu = new Menu();
        Data data = new Data();
        Manager manager = new Manager();
        ArrayList<User>  users = data.inputDB("Users.txt");
        while(true){
            int choice = menu.getChoice(1, 2);
            switch(choice){
                case 1: 
                    manager.addUser(users);
                    data.saveDB(users, "Users.txt");
                    break;
                case 2:
                    manager.login(users);
                    data.saveDB(users, "Users.txt");
                    break;
                case 3: 
                    return;
            }
        }
    }
    
}
