n=int(input())
t,p=[0 for i in range(n+1)],[0 for i in range(n+1)]
for i in range(n):
    a,b=map(int,input().split())
    t[i]=a
    p[i]=b
dp=[0 for i in range(n+1)]

for i in range(n-1,-1,-1):
    if t[i]+i>n:
        dp[i]=dp[i+1]
    else:
        dp[i]=max(p[i]+dp[i+t[i]],dp[i+1])
print(dp[0])