import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // soal 1
        soal1();

        // soal 2
        soal2();

        System.out.println("\nGagas Surya Laksana - 1301223164");
    }

    // soal 1
    public static void soal1() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Soal 1 - Fibonacci");
        System.out.print("Input bilangan: ");
        int n = scanner.nextInt();
        printFibonacci(n);

        System.out.print("\nInput bilangan: ");
        n = scanner.nextInt();
        printFibonacci(n);
    }

    public static void printFibonacci(int n) {
        int a = 1, b = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int temp = a + b;
            a = b;
            b = temp;
        }
    }

    // soal 2
    public static void soal2() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\nSoal 2 - Perkalian Matriks");
        System.out.print("n: ");
        int n = scanner.nextInt();
        
        int[][] matrix1 = new int[n][n];
        int[][] matrix2 = new int[n][n];
        
        System.out.println("Isi matrix 1:");
        inputMatrix(matrix1, scanner);
        
        System.out.println("Isi matrix 2:");
        inputMatrix(matrix2, scanner);
        
        System.out.println("Matrix 1:");
        printMatrix(matrix1);
        
        System.out.println("Matrix 2:");
        printMatrix(matrix2);
        
        int[][] result = perkalianMatriks(matrix1, matrix2);
        
        System.out.println("Hasil perkalian:");
        printMatrix(result);
        
        scanner.close();
    }
    
    public static void inputMatrix(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        System.out.println();
    }
    
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
    
    public static int[][] perkalianMatriks(int[][] matrix1, int[][] matrix2) {
        int n = matrix1.length;
        int[][] result = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        
        return result;
    }
}