
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Person {

    Wallet Wallet;

//    // User enter number of bills 
    public int inputSize() {
        Scanner sc = new Scanner(System.in);
        System.out.print("input value of wallet: ");
        while (true) {
            try {
                String tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    System.out.println("Please dont let input blank.");
                } else {
                    int size = Integer.parseInt(tmp);
                    if (size < 0) {
                        System.err.println("Input is greater than zero.");
                        System.out.println("Please re-input:");
                    } else {
                        return size;
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("You must input digit.");
                System.out.println("Please input re-input:");
            }
        }
    }

    //Get array bills that user input
    public int[] inputBills() {
        Scanner sc = new Scanner(System.in);
        System.out.println("======= Shopping program =======");
        int[] bills = new int[inputSize()];
        System.out.print("input number of bill: ");
        //Loop to input single bill
        for (int i = 0; i < bills.length; i++) {
            while (true) {
                try {
                    String tmp = sc.nextLine();
                    if (tmp.isEmpty()) {
                        System.out.println("Please dont let input blank.");

                    } else {
                        int input = Integer.parseInt(tmp);
                        if (input < 0) {
                            System.err.println("Input is greater than zero.");
                            System.out.println("Please re-input:");
                        } else {
                            bills[i] = input;
                        }
                    }
                } catch (NumberFormatException e) {
                    System.err.println("You must input digit.");
                    System.out.println("Please input re-input:");
                }
            }
        }
        return bills;
    }

    //Check input is positive number and return
    public int checkAndReturnInputBills() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                String tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    System.out.println("Please dont let input blank.");
                } else {
                    int input = Integer.parseInt(tmp);
                    if (input <= 0) {
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

    //Calculate the total amount of the bills
    public int sumBills(int[] bills) {
        int total = 0;
        for (int i = 0; i < bills.length; i++) {
            total += bills[i];
        }
        return total;
    }
}
