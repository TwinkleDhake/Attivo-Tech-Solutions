r1 = int(input("Rows in Matrix A: "))
c1 = int(input("Columns in Matrix A: "))
r2 = int(input("Rows in Matrix B: "))
c2 = int(input("Columns in Matrix B: "))
if c1 != r2:
    print("Matrix Multiplication cannot be done")
else:
    print("Enter Matrix A: ")
    A = [[int(x) for x in input(). split()] for _ in range(r1)]
    
    print("Enter Matrix B: ")
    B = [[int(x) for x in input(). split()] for _ in range(r2)]

    result = [[0 for _ in range(c2)] for _ in range(r1)]
    for i in range(r1):
        for j in range(c2):
            for k in range(c1):
                result[i][j] += A[i][k] * B[k][j]
    print("Result: ")
    for row in result:
        print(*row)