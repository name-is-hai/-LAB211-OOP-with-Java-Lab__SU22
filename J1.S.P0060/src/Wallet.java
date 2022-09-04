
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
public class Wallet {
    
    //User input the value of wallet
    public int inputWallet() {
        Scanner sc = new Scanner(System.in);
        System.out.print("input value of wallet: ");
        while (true) {
            try {
                String tmp = sc.nextLine();
                if (tmp.isEmpty()){
                    System.out.println("Please dont let input blank.");
                   
                }else{
                    int input = Integer.parseInt(tmp);
                    if (input < 0) {
                        System.err.println("Input is greater than zero.");
                        System.out.println("Please re-input:");
                    } else {
                        return input;
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("You must input digit.");
                System.out.println("Please input re-input:");
            }
        }
    }
    
    //Compera value of bills and the amount in the wallet is enough to pay. 
    public boolean ComperaBillsVSWallet(int total, int wallet) {
        return total <= wallet;
    }

    //Print the message that user can pay or not
    public void payMoney(int total, boolean payMoney ) {
        System.out.println("this is total of bill: " + total);
        if (payMoney) {
            System.out.println("You can buy it.");
        } else {
            System.out.println("You can't buy it.");
        }
    }
}
