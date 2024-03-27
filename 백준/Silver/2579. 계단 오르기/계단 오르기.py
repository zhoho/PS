n=int(input())
nlist,dp=[0 for i in range(301)],[0 for i in range(301)]
for i in range(n):
  nlist[i]=int(input())
dp[0]=nlist[0]
dp[1]=nlist[0]+nlist[1]
dp[2]=max(nlist[1]+nlist[2],nlist[0]+nlist[2])
for i in range(3,n):
  dp[i]=max(dp[i-3]+nlist[i-1]+nlist[i],dp[i-2]+nlist[i])
print(dp[n-1])