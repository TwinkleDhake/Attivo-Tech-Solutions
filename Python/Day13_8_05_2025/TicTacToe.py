# Q3. TicTacToe program
def print_board(board):
    for row in board:
        print(" | ".join(row))
        print("-" * 5)
def check_winner(board, player):
    for row in board:
        if all(cell == player for cell in row):
            return True
    for col in range(3):
        if all(board[row][col] == player for row in range(3)):
            return True
    if all(board[i][i] == player for i in range(3)):
        return True
    if all(board[i][2 - i] == player for i in range(3)):
        return True
    return False
def is_draw(board):
    return all(cell in ['X', 'O'] for row in board for cell in row)
def get_move(player):
    while True:
        try:
            row = int(input(f"{player}'s Turn - Enter row (0-2): "))
            col = int(input(f"{player}'s Turn - Enter column (0-2): "))
            if row in range(3) and col in range(3):
                return row, col
            else:
                print("Invalid input. Please enter values between 0 and 2.")
        except ValueError:
            print("Invalid input. Please enter numbers only.")
def play_game():
    board = [[" " for _ in range(3)] for _ in range(3)]
    current_player = "X"
    while True:
        print_board(board)
        row, col = get_move(current_player)
        if board[row][col] == " ":
            board[row][col] = current_player
        else:
            print("Cell already taken. Choose another.")
            continue
        if check_winner(board, current_player):
            print_board(board)
            print(f"Player {current_player} wins!")
            break
        elif is_draw(board):
            print_board(board)
            print("It's a draw!")
            break
        current_player = "O" if current_player == "X" else "X"
if __name__ == "__main__":
    play_game()