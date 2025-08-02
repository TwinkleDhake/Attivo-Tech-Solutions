import java.util.Scanner;
public class MatrixTranspose {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner (System.in)) {
            System.out.print("Enter number of rows: ");
            int rows = scanner.nextInt();
            System.out.print("Enter number of columns: ");
            int cols = scanner.nextInt();
            int[][] matrix = new int[rows][cols];
            System.out.println("Enter matrix elements:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            int[][] transpose = new int[cols][rows];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    transpose[j][i] = matrix[i][j];
                }
            }
            System.out.println("Transposed matrix:");
            for (int i = 0; i < cols; i++) {
                for (int j = 0; j < rows; j++) {
                    System.out.print(transpose[i][j] + " ");
                }
                System.out.println();
            }
        }
    }    
}