# Q1. Sudoku board puzzle game (9 x 9) grid. use a random value so that it can be filled by code itself. use algorithm. Take user input.
import random
def is_valid(grid, row, col, num):
    for i in range(9):
        if grid[row][i] == num or grid[i][col] == num:
            return False
    start_row, start_col = 3 * (row // 3), 3 * (col // 3)
    for i in range(start_row, start_row + 3):
        for j in range(start_col, start_col + 3):
            if grid[i][j] == num:
                return False
    return True
def solve(grid):
    for row in range(9):
        for col in range(9):
            if grid[row][col] == 0:
                nums = list(range(1, 10))
                random.shuffle(nums)
                for num in nums:
                    if is_valid(grid, row, col, num):
                        grid[row][col] = num
                        if solve(grid):
                            return True
                        grid[row][col] = 0
                return False
    return True
def generate_sudoku(remove_count=40):
    grid = [[0 for _ in range(9)] for _ in range(9)]
    solve(grid)
    removed = 0
    while removed < remove_count:
        row, col = random.randint(0, 8), random.randint(0, 8)
        if grid[row][col] != 0:
            grid[row][col] = 0
            removed += 1
    return grid
def print_grid(grid):
    for i in range(9):
        if i % 3 == 0 and i != 0:
            print("-" * 21)
        for j in range(9):
            if j % 3 == 0 and j != 0:
                print("|", end=" ")
            print(grid[i][j] if grid[i][j] != 0 else ".", end=" ")
        print()
def play():
    board = generate_sudoku()
    while True:
        print_grid(board)
        move = input("Enter row,col,number (or 'q' to quit): ")
        if move.lower() == 'q':
            break
        try:
            row, col, num = map(int, move.split(","))
            if board[row][col] != 0:
                print("Cell already filled!")
            elif not is_valid(board, row, col, num):
                print("Invalid move!")
            else:
                board[row][col] = num
        except:
            print("Invalid input. Use format row,col,num")
play()