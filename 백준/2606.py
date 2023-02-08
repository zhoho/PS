computer = int(input())
Connecting = int(input())
graph = [[] for i in range(computer+1)]
visited = [0] * (computer+1)
for i in range(Connecting):
    a, b = map(int, input().split())
    graph[a] += [b]
    graph[b] += [a]
count = 0


def dfs(start):
    global count
    visited[start] = 1
    for i in graph[start]:
        # print('i = ', i)
        if visited[i] == 0:
            dfs(i)
            count += 1


dfs(1)
print(count)
