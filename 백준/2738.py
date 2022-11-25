n, m = map(int,input().split())
matrix_1 = []
matrix_2 = []
for _ in range(n):
    row = list(map(int,input().split()))
    matrix_1.append(row)
for _ in range(n):
    row = list(map(int,input().split()))
    matrix_2.append(row)

for i in range(n):
    for j in range(m):
        matrix_1[i][j] += matrix_2[i][j]
    print(*matrix_1[i])