def dfs(v):
    visit[v]=1
    print(v, end=' ')
    for i in range(1, n+1):
        if visit[i]==0 and graph[v][i]==1:
            dfs(i)
           
def bfs(v):
    queue=[v]
    visit_bfs[v]=1
    while queue:
        v = queue.pop(0)
        print(v, end=' ')
        for i in range(1, n+1):
            if visit_bfs[i]==0 and graph[v][i]==1:
                queue.append(i)
                visit_bfs[i]=1
            
n,m,v=map(int,input().split())

graph =[[0]*(n+1) for _ in range(n+1)]
visit=[0]*(n+1)
visit_bfs = visit.copy()


for i in range(m):
    x,y=map(int,input().split())
    graph[x][y]=1
    graph[y][x]=1
    
dfs(v)
print()
bfs(v)