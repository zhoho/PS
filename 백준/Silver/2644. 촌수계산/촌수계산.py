n = int(input())
a, b = map(int, input().split())
m = int(input())
graph = [[False] * (n+1) for _ in range(n + 1)]
visited = [False] * (n + 1)

for _ in range(m):
    x, y = map(int, input().split())
    graph[x][y] = True
    graph[y][x] = True

def dfs(cur, tar, depth):
    if cur == tar:
        return depth
    visited[cur] = True

    for i in range(1, n + 1):
        if graph[cur][i] and not visited[i]:
            result = dfs(i, tar, depth + 1)
            if result != -1:
                return result
    return -1
result = dfs(a, b, 0)
print(result)