// Q7. TicTacToe program in java using method.
import java.util.Scanner;
public class TicTacToe {
    static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        char currentPlayer = 'X';
        boolean gameEnded = false;
        System.out.println("Welcome to Tic-Tac-Toe!");
        while (!gameEnded) {
            printBoard();
            playerMove(currentPlayer);
            if (checkWin(currentPlayer)) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                gameEnded = true;
            } else if (isDraw()) {
                printBoard();
                System.out.println("It's a draw!");
                gameEnded = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; // Switch player
            }
        }
    }
    public static void printBoard() {
        System.out.println("Board:");
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) System.out.println("---|---|---");
        }
    }
    public static void playerMove(char player) {
        int row, col;
        while (true) {
            System.out.println("Player " + player + ", enter your move (row and column: 0 1 2):");
            row = scanner.nextInt();
            col = scanner.nextInt();
            if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                if (board[row][col] == ' ') {
                    board[row][col] = player;
                    break;
                } else {
                    System.out.println("Cell already taken. Choose again.");
                }
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
    }
    public static boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player &&
                 board[i][1] == player &&
                 board[i][2] == player) ||
                (board[0][i] == player &&
                 board[1][i] == player &&
                 board[2][i] == player)) {
                return true;
            }
        }
        return (board[0][0] == player &&
                board[1][1] == player &&
                board[2][2] == player) ||
                (board[0][2] == player &&
                board[1][1] == player &&
                board[2][0] == player);
    }
    public static boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}