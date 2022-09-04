
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
class Menu {

    public int getChoice(int min , int max){
        System.out.println("======== Worker Management ========");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
        System.out.println("Your Choice:");
        Scanner sc = new Scanner(System.in);
        // until user input correct
        while(true){
            try {
                String tmp = sc.nextLine();
                //input can not be empty
                if (tmp.isEmpty()){
                    System.out.println("You need to choice in range [" + min + ", " + max +"]");
                    System.out.println("Please re-choice:");
                } else {
                    int choice = Integer.parseInt(tmp.trim());
                    if(choice < min || choice > max){
                    System.out.println("You need to choice in range [" + min + ", " + max +"]");
                    System.out.println("Please re-choice:");                       
                    }
                    else return choice;
                }
            } catch (NumberFormatException e) {
                    System.out.println("You need to choice in range [" + min + ", " + max +"]");
                    System.out.println("Please re-choice:");   
            }
  
        }
    }
    
}
