/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0010;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class J1SP0010 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Step 1: Users to input the size of array. 
        int size = inputSize();
        //Step 2: Generate random array.
        int[] arr = getRadomArray(size);
        //Step 3: Users input a positive decimal number, want to search.
        int key = inputPositiveDecimalNum();
        //Step 4: Display the array
        displayArray(arr);
        //Step 5: Display the index of search number in array.
        displayIndex(arr, key);
    }

    private static int inputSize() {
        System.out.println("Enter number of array:");
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                String tmp = sc.nextLine();
                //do not let user enter blank
                if (tmp.isEmpty()) {
                    System.out.println("Please dont let input blank.");
                    System.out.println("Please re-input:");
                } else {
                    int input = Integer.parseInt(tmp);
                    //do not let user enter non-positive decimal number.
                    if (input <= 0) {
                        System.err.println("Input is greater than zero.");
                        System.out.println("Please re-input:");
                        //return input if it is positive decimal number.
                    } else {
                        return input;
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("You must input positive decimal number.");
                System.out.println("Please re-input:");
            }
        }
    }

    public static int[] getRadomArray(int size) {
        int[] array = new int[size];
        //add each random element into array
        for (int i = 0; i < size; i++) {
            array[i] = new Random().nextInt(size);
        }
        return array;
    }

    private static int inputPositiveDecimalNum() {
        System.out.println("Enter search value:");
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                String tmp = sc.nextLine();
                //do not let user enter blank
                if (tmp.isEmpty()) {
                    System.out.println("Please dont let input blank.");
                } else {
                    int input = Integer.parseInt(tmp);
                    //do not let user enter non-positive decimal number.
                    if (input <= 0) {
                        System.err.println("Input is greater than zero.");
                        System.out.println("Please re-input:");
                    } //return input if it is positive decimal number.
                    else {
                        return input;
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("You must input digit.");
                System.out.println("Please re-input:");
            }
        }
    }

    public static void displayArray(int[] arr) {
        System.out.print("The array: [");
        //display each element in array.
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            //Not to display one null element at the end of array
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    private static void displayIndex(int[] arr, int key) {
        int size = arr.length;
        int count = 0;
        //search each element in array to find number user want to find.
        for (int i = 0; i < size; i++) {
            //find out the number user want in array
            if (arr[i] == key) {
                System.out.println("Found " + key + " at index: " + i + ".");
                count++;
            }
        }
        //can not find the number user want in array
        if (count <= 0) {
            System.out.println("");
            System.out.println("Not found " + key + " in array.");
        }
    }
}
