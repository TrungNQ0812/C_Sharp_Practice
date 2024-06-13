package p0074_calculator_program;

import java.util.Scanner;

public class P0074 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        P0074 cl = new P0074();
        boolean isExit = false;
        while (!isExit) {
            cl.Menu();
            System.out.println("Your choice:");
            int choice = sc.nextInt();
            int[][] a, b;
            switch (choice) {
                case 1:
                    a = cl.NhapMatrix(1);
                    b = cl.NhapMatrix(2);
                    if (cl.CalMatrix(a, b,1) == null) {
                        System.err.println("Cannot add 2 matrix");
                        System.out.println();
                    } else {
                        cl.displayResult("Addition", '+', a, b, cl.CalMatrix(a, b, 1));
                    }
                    break;

                case 2:
                    a = cl.NhapMatrix(1);
                    b = cl.NhapMatrix(2);
                    if (cl.CalMatrix(a, b,-1) == null) {
                        System.err.println("Cannot sub 2 matrix");
                        System.out.println();
                    } else {
                        cl.displayResult("Subtraction", '-', a, b, cl.CalMatrix(a, b,-1));
                    }
                    break;

                case 3:
                    a = cl.NhapMatrix(1);
                    b = cl.NhapMatrix(2);
                    if (cl.MulMatrix(a, b) == null) {
                        System.err.println("Cannot mul 2 matrix");
                        System.out.println();
                    } else {
                        cl.displayResult("Multiplication", '*', a, b, cl.MulMatrix(a, b));
                    }
                    break;

                case 4:
                    System.out.println("Exit!!!");
                    isExit = true;
                    break;
            }
        }
    }

    public void Menu() {
        System.out.println("=====Calculator prgram=====");
        System.out.println("1. Addition Matrix");
        System.out.println("2.Subtraction Matrix");
        System.out.println("3.Multiplication Matrix");
        System.out.println("4.Quit");
    }

    public int getInt(String mess) {
        while (true) {
             System.out.println(mess);
            try {
                int numb=sc.nextInt();
                if (numb<=0) {
                    System.out.println("Please input an positive integer ");
                    continue;
                }
                return numb;
            } catch (Exception e) {
                System.out.println("Please input an integer number: ");
                sc.next();
            }
        }
    }

    public int add(int a, int b){
        return a + b;
    }
    
    public int[][] NhapMatrix(int matrix) {
        int row = getInt("Enter row of matrix" + matrix);
        int column = getInt("Enter column of matrix" + matrix);
        int[][]a = new int[row][column];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print("Enter Matrix[" + (i + 1) + "][" + (j + 1) + "]: ");
                try {
                    a[i][j] = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Value of digit is digit");
                    sc.next();
                    j--;
                }
            }
        }
        return a;
    }

    public void Display(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print("[" + a[i][j] + "] ");
            }
            System.out.println();
        }
    }

    public void displayResult(String mess, char k, int[][] a, int[][] b, int[][] result) {
        System.out.println("-------" + mess + "-------");
        Display(a);
        System.out.println(k);
        Display(b);
        System.out.println("=");
        Display(result);
    }

    public int[][] CalMatrix(int[][] a, int[][] b, int k) {
        if (a.length != b.length || a[0].length != b[0].length) {
            return null;
        }
        int[][] result = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                    result[i][j] = a[i][j] + k*b[i][j];
            }
        }
        return result;
    }

    public int[][] MulMatrix(int[][] a, int[][] b) {
        if (a[0].length != b.length) {
            return null;
        }
        int[][] result = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    result[i][j] = result[i][j] + a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }
}
