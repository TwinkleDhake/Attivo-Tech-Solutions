import java.util.Scanner;
public class MatrixMultiplication {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner (System.in)) {
            int[][] a = new int[2][2];
            int[][] b = new int[2][2];
            int[][] result = new int[2][2];
            System.out.println("Enter elements of the first 2 x 2 matrix:");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            System.out.println("Enter elements of the second 2 x 2 matrix:");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    b[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 2; k++) {
                        result[i][j] += a[i][k] * b[k][j];
                    }
                }
            }   
            System.out.println("Resultant matrix:");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}