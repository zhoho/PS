home=[]
N=int(input())
for i in range(N):
  home.append(list(map(int,input().split())))

for i in range(1,N):
    home[i][0]=min(home[i-1][1],home[i-1][2])+home[i][0]
    home[i][1]=min(home[i-1][0],home[i-1][2])+home[i][1]
    home[i][2]=min(home[i-1][0],home[i-1][1])+home[i][2]
print(min(home[N-1]))