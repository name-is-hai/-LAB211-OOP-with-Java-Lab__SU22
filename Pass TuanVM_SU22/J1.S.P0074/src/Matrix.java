
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class Matrix {

    public int inputRowMatix1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Row Matrix 1:");
        while (true) {
            try {
                String tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    System.out.println("Can not be blank.");
                    System.out.println("re-enter:");
                } else {
                    int row = Integer.parseInt(tmp);
                    if (row <= 0) {
                        System.out.println("Can not <= 0");
                        System.out.println("Re- enter:");
                    } else {
                        return row;
                    }
                }
            } catch (Exception e) {
                System.out.println("Need to be digit:");
                System.out.println("Re-enter:");
            }
        }
    }

    public int inputCollumnMatix1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Collumn Matrix 1:");
        while (true) {
            try {
                String tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    System.out.println("Can not be blank.");
                    System.out.println("re-enter:");
                } else {
                    int column = Integer.parseInt(tmp);
                    if (column <= 0) {
                        System.out.println("Can not <= 0");
                        System.out.println("Re- enter:");
                    } else {
                        return column;
                    }
                }
            } catch (Exception e) {
                System.out.println("Need to be digit:");
                System.out.println("Re-enter:");
            }
        }
    }

    public int inputRowMatix2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Row Matrix 2:");
        while (true) {
            try {
                String tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    System.out.println("Can not be blank.");
                    System.out.println("re-enter:");
                } else {
                    int row = Integer.parseInt(tmp);
                    if (row <= 0) {
                        System.out.println("Can not <= 0");
                        System.out.println("Re- enter:");
                    } else {
                        return row;
                    }
                }
            } catch (Exception e) {
                System.out.println("Need to be digit:");
                System.out.println("Re-enter:");
            }
        }
    }

    public int inputCollumnMatix2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Collumn Matrix 2:");
        while (true) {
            try {
                String tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    System.out.println("Can not be blank.");
                    System.out.println("re-enter:");
                } else {
                    int column = Integer.parseInt(tmp);
                    if (column <= 0) {
                        System.out.println("Can not <= 0");
                        System.out.println("Re- enter:");
                    } else {
                        return column;
                    }
                }
            } catch (Exception e) {
                System.out.println("Need to be digit:");
                System.out.println("Re-enter:");
            }
        }
    }

    public int inputInt() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                String tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    System.out.println("Can not be blank.");
                    System.out.println("re-enter:");
                } else {
                    int input = Integer.parseInt(tmp);
                    return input;
                }
            } catch (Exception e) {
                System.out.println("Need to be digit:");
                System.out.println("Re-enter:");
            }
        }
    }

    public int[][] inputMatrix1() {
        int row = inputRowMatix1();
        int col = inputCollumnMatix1();
        int[][] maxtrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Enter Matrix1[" + (i + 1) + "]" + "[" + (j + 1) + "]:");
                maxtrix[i][j] = inputInt();
            }
        }
        return maxtrix;
    }

    public int[][] inputMatrix2(int[][] matrix1) {
        int row = inputRowMatix2();
        int col = inputCollumnMatix2();
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int[][] maxtrix = new int[row][col];
        if(checkAdd(row, col, row1, col1)){
        return null;
        }else{
            
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Enter Matrix1[" + (i + 1) + "]" + "[" + (j + 1) + "]:");
                maxtrix[i][j] = inputInt();
            }
        }
        return maxtrix;
        }

    }

    public void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int collumn = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < collumn; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println("");
        }
    }

    public int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        System.out.println("-------- Addition --------");
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        System.out.println("-------- Result --------");
        displayMatrix(matrix1);
        System.out.println("+");
        displayMatrix(matrix2);
        System.out.println("=");
        int[][] matrixResult = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                matrixResult[i][j] = (matrix1[i][j] + matrix2[i][j]);
            }
        }
        return matrixResult;
    }

    public int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        System.out.println("-------- Subtraction --------");
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        System.out.println("-------- Result --------");
        displayMatrix(matrix1);
        System.out.println("-");
        displayMatrix(matrix2);
        System.out.println("=");
        int[][] matrixResult = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                matrixResult[i][j] = (matrix1[i][j] - matrix2[i][j]);
            }
        }
        return matrixResult;
    }

    public int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        System.out.println("-------- Multiplication --------");
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        System.out.println("-------- Result --------");
        displayMatrix(matrix1);
        System.out.println("*");
        displayMatrix(matrix2);
        System.out.println("=");

        int[][] matrixResult = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    matrixResult[i][j] += (matrix1[i][k] * matrix2[k][j]);
                }
            }
        }
        return matrixResult;
    }

    public boolean checkAdd(int row1, int col1, int row2, int col2) {
        if ((row1 != row2) && (col1 != col2)) {
            return false;
        }
        return true;
    }
}
