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
        show1(145);
        System.out.println("");
        show2(134);
        int[] array = {-6, 0, -2, 8, 1};
        System.out.println("");
        System.out.println(findmax(array, 5));
        System.out.println("");
        System.out.println(findsum(array, 5));
    }

    private static void show1(int n) {
        System.out.print(n % 10 + " ");
        if (n > 0) {
            show1(n / 10);
        }
        System.out.print(n % 10 + " ");

    }

    private static void show2(int n) {
        System.out.print(n % 10 + " ");
        if (n > 0) {
            show2(n / 10);
        }
    }

    private static int findmax(int[] array, int n) {
        if (n == 1) {
            return array[0];
        }
        if (array[n - 1] > findmax(array, n - 1)) {
            return array[n - 1];
        }
        return findmax(array, n - 1);
    }

    private static int findsum(int[] a, int n) {
        if (n == 0) {
            return 0;
        } else {
            if (a[n - 1] > 0) {
                return findsum(a, n - 1) + a[n - 1];
            }
            return findsum(a, n - 1);
        }
    }
}
