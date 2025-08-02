def solve_n_queens(n):
    def is_safe(row, col, diagonals, anti_diagonals, cols):
        return col not in cols and (row - col) not in diagonals and (row + col) not in anti_diagonals
    def backtrack(row, diagonals, anti_diagonals, cols, state):
        if row == n:
            result.append(["".join(r) for r in state])
            return
        for col in range(n):
            if is_safe(row, col, diagonals, anti_diagonals, cols):
                state[row][col] = "Q"
                cols.add(col)
                diagonals.add(row - col)
                anti_diagonals.add(row + col)
                backtrack(row + 1, diagonals, anti_diagonals, cols, state)
                state[row][col] = "."
                cols.remove(col)
                diagonals.remove(row - col)
                anti_diagonals.remove(row + col)
    result = []
    empty_board = [["." for _ in range(n)] for _ in range(n)]
    backtrack(0, set(), set(), set(), empty_board)
    return result
solutions = solve_n_queens(4)
for sol in solutions:
    for row in sol:
        print(row)
    print()