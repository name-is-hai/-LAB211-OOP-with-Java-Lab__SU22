
import java.util.ArrayList;

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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
           // TODO code application logic here
        Menu menu = new Menu();
        Data data = new Data();
        Manager manager = new Manager();
        ArrayList<User>  users = data.inputDB("user.dat");
        while(true){
            int choice = menu.getChoice(1, 3);
            switch(choice){
                case 1: 
                    manager.createNewAcc(users);
                    data.saveDB(users, "user.dat");
                    break;
                case 2:
                    manager.login(users);
                    data.saveDB(users, "user.dat");
                    break;
                case 3: 
                    return;
            }
        }
    }
    
}
