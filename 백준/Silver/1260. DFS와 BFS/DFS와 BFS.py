## 타도 bfs dfs
from collections import deque
n, m, v = map(int, input().split())

graph = [[False] * (n + 1) for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a][b] = True
    graph[b][a] = True

dfsvisited = [False] * (n + 1)
bfsvisited = [False] * (n + 1)

def bfs(v):
    q = deque([v])
    bfsvisited[v] = True
    while q:
        v = q.popleft()
        print(v, end =" ")
        for i in range(1, n + 1):
            if not bfsvisited[i] and graph[v][i]:
                q.append(i)
                bfsvisited[i] = True

def dfs(v):
    dfsvisited[v] = True
    print(v, end= " ")
    for i in range(1, n + 1):
        if not dfsvisited[i] and graph[v][i]:
            dfs(i)

dfs(v)
print()
bfs(v)