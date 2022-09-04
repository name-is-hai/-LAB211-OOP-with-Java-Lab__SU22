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
        Menu menu = new Menu();
        Matrix matrix = new Matrix();
        //Step 1: Display choice for users to select an option
        while (true) {
            int choice = menu.getChoice(1, 4);
            switch (choice) {
                //user choice 1
                case 1:
                    //Display result
                    int [][]matrix1 = matrix.inputMatrix1();
                    int [][]matrix2 = matrix.inputMatrix1();
                    
                   int[][] matrixResult = matrix.additionMatrix(matrix1, matrix2);
                   matrix.displayMatrix(matrixResult);
                    break;
                case 2:
                    //Display result
                   
                    break;
                case 3:
                    
                    //Display result
                    break;
                case 4:
                    return;
            }
        }
    }
}
