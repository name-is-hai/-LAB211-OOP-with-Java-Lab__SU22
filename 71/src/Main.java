
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
    public static void main(String[] args) {
                Menu menu = new Menu();
        Data data = new Data();
        Manager manager = new Manager();
        ArrayList<Task> tasks = data.inputDB("Tasks.txt");
        int id = 1;
        while(true){
            int choice = menu.getChoice(1, 4);
            switch(choice){
                case 1: 
                    manager.addTask(id, tasks);
                    id++;
                    data.saveDB(tasks, "Tasks.txt");
                    break;
                case 2:
                    manager.deleteTask(tasks);
                    id --;
                    data.saveDB(tasks, "Tasks.txt");
                    break;
                case 3:
                    manager.print(tasks);
                    break;
                case 4:
                    return;
            }
        }
    }
}
