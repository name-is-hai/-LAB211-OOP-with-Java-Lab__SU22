/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Main;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class J1SP0009 {

    public static void main(String[] args) {
        //Step 1: display 45 first fibonacci number
        displayFibo(45);
    }
    
    public static int Fibonacci (int n1, int n2, int n){
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        return Fibonacci(n2, n2 + n1, n - 1);
    }
    
    public static void displayFibo(int size){
        ArrayList<Integer> num = new ArrayList<>();
        for (int i = 0 ; i < size; i ++){
            num.add(Fibonacci(0, 1, i));
        }
        
        for (int i = 0; i < size; i ++){
            System.out.println("");
            System.out.println(num.get(i) + ", ");
        }
    }
}
