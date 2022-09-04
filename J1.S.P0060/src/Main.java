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
        Wallet wallet = new Wallet();
        Person person = new Person();
        //Step 1: allow user input input bill
        int[] bills = person.inputBills();
        //Step 2: allow user input amount of wallet
        int wallets = wallet.inputWallet();
        //Step 3: Calculate total bills
        int total = person.sumBills(bills);
        //Step 4: Compare between bills and wallet
        boolean ComperaBillsVSWallet = wallet.ComperaBillsVSWallet(total, wallets);
        //Step 5: Print the message that user can pay or not
        wallet.payMoney(total, ComperaBillsVSWallet);
    }
}
