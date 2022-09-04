package Controller;

import java.util.Scanner;

public class Helpers {

    Scanner in;

    public Helpers() {
        in = new Scanner(System.in);
    }

    protected int checkInt() {
        String n = "";
        int a=0;
        while (a<=0) {
            n = in.nextLine();
            try {
               a = Integer.parseInt(n);
                if(a <0 ) throw  new Exception();
            } catch (Exception e) {
                System.out.println("Enter again!");
            }
        }
        return a;
    }
    
     public double checkDoub() {
        String n = "";
        while (true) {
            n = in.nextLine();
            try {
                return Double.parseDouble(n);
            } catch (Exception e) {
                System.out.println("Enter again!");
            }
        }
    }

}
