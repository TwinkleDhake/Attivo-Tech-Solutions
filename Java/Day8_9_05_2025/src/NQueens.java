public class NQueens {
    static int N;
    public static void printSolution(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print((cell == 1 ? "Q " : ". "));
            }
            System.out.println();
        }
        System.out.println();
    }
    public static boolean isSafe(int[][] board, int row, int col) {
        for (int i = 0; i < row; i++)
            if (board[i][col] == 1)
                return false;
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;
        for (int i = row, j = col; i >= 0 && j < N; i--, j++)
            if (board[i][j] == 1)
                return false;
        return true;
    }
    public static boolean solveNQueens(int[][] board, int row) {
        if (row == N) {
            printSolution(board);
            return true;
        }
        boolean res = false;
        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;
                res = solveNQueens(board, row + 1) || res;
                board[row][col] = 0;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        N = 8;
        int[][] board = new int[N][N];   
        if (!solveNQueens(board, 0)) {
            System.out.println("No solution exists");
        }
    }
}