n=int(input())
graph=[]
num=[]
dx=[0,0,-1,1]
dy=[-1,1,0,0]
for _ in range(n):
  graph.append(list(map(int,input())))

def dfs(x,y):
  if x<0 or y<0 or x>=n or y>=n:
    return False
  if graph[x][y]==1:
    global count
    count+=1
    graph[x][y]=0
    for i in range(4):
      nx=x+dx[i]
      ny=y+dy[i]
      dfs(nx,ny)
    return True
  return False

count=0
result=0

for i in range(n):
  for j in range(n):
    if dfs(i,j)==True:
      num.append(count)
      result+=1
      count=0

print(result)
num.sort()
for i in range(len(num)):
  print(num[i])