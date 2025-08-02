/* # Q1. Sudoku board puzzle game (9 x 9) grid. use a random value so that it can be filled by code itself. 
use algorithm. Take user input. */

import java.util.*;
public class Sudoku {
    static int[][] board = new int[9][9];
    public static void main(String[] args) {
        generateFullBoard();
        removeCells(40);
        playGame();
    }
    static boolean solveBoard(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    List<Integer> numbers = getShuffledNumbers();
                    for (int num : numbers) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solveBoard(board)) return true;
                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    static boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num)
                return false;
        }
        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (board[i][j] == num)
                    return false;
            }
        }
        return true;
    }
    static void generateFullBoard() {
        solveBoard(board);
    }
    static void removeCells(int count) {
        Random rand = new Random();
        int removed = 0;
        while (removed < count) {
            int row = rand.nextInt(9);
            int col = rand.nextInt(9);
            if (board[row][col] != 0) {
                board[row][col] = 0;
                removed++;
            }
        }
    }
    static List<Integer> getShuffledNumbers() {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 9; i++) nums.add(i);
        Collections.shuffle(nums);
        return nums;
    }
    static void printBoard() {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0)
                System.out.println("------+-------+------");
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0)
                    System.out.print("| ");
                System.out.print((board[i][j] == 0 ? "." : board[i][j]) + " ");
            }
            System.out.println();
        }
    }
    static void playGame() {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                printBoard();
                System.out.println("Enter row (0-8), column (0-8), number (1-9), or -1 to quit:");
                int row = sc.nextInt();
                if (row == -1) break;
                int col = sc.nextInt();
                int num = sc.nextInt();
                if (row < 0 || row > 8 || col < 0 || col > 8 || num < 1 || num > 9) {
                    System.out.println("Invalid input range. Try again.");
                    continue;
                }
                if (board[row][col] != 0) {
                    System.out.println("Cell already filled!");
                } else if (isValid(board, row, col, num)) {
                    board[row][col] = num;
                } else {
                    System.out.println("Invalid move!");
                }
            }
        }
    }
}