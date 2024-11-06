def dfs(start, depth):
    if depth == 6:
        for i in range(6):
            print(answer[i], end=' ')
        print()
        return
    for i in range(start, len(S)):
        answer[depth] = S[i]
        dfs(i + 1, depth + 1)
answer = [0 for i in range(13)]
while 1:
    S = list(map(int, input().split()))
    K = S[0]
    if K == 0:
        break
    del S[0]
    dfs(0, 0)
    print()
