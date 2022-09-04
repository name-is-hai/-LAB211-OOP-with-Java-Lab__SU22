
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
        System.out.printf("%-5s%-15s%-5s%-10s%-10s%-20s\n", "Code", "Name", "Age","Salary", "Status", "Date");
        //Step 1 : Print first line 
        firstLine();
        //Step 1: display 45 first fibonacci number
        displayFibo(45);
    }
    
    public static int Fibonacci (int n1, int n2, int n){
        if (n == 0){
            return n1;
        }
        if (n == 1){
            return n2;
        }
        return Fibonacci(n2, n2 + n1, n - 1);
    }
    
    public static void firstLine (){
        System.out.println("The 45 sequence Fibonacci:");
    }
    
    public static void displayFibo(int size){
        ArrayList<Integer> num = new ArrayList<>();
        for (int i = 0 ; i < size; i ++){
            num.add(Fibonacci(0, 1, i));
        }
        for (int i = 0; i < size; i ++){
            System.out.print("(" + (i+1) + ")");
            System.out.print( num.get(i));
            // System.out.println("");
            if (i < size-1){
                System.out.print(", ");
            }
        }
    }
    
}
