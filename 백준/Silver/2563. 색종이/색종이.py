n = int(input())
paper = [[0] * 100 for _ in range(100)]
for _ in range(n):
    x, y = map(int, input().split())
    for i in range(x, x + 10):
        for j in range(y, y + 10):
            paper[i][j] = 1

ans = sum(sum(row) for row in paper)
print(ans)
