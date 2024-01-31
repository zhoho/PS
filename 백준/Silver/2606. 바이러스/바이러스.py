def dfs(start):
    global count
    visited[start] = 1
    for i in graph[start]:
        if visited[i] == 0:
            dfs(i)
            count += 1

computer = int(input())
connecting = int(input())
graph = [[] for _ in range(computer+1)]
visited = [0] * (computer+1)
for i in range(connecting):
    a, b = map(int, input().split())
    graph[a] += [b]
    graph[b] += [a]
count = 0


dfs(1)
print(count)