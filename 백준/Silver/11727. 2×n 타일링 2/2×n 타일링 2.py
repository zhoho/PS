n=int(input())
if n==1:
    print(1)
else:
    dp=[0 for _ in range(n+1)]
    dp[1]=1;dp[2]=3
    for i in range(3,n+1):
        if i%2==1: #홀수
            dp[i]=((dp[i-2]*4)+1)%10007
        else: #짝수
            dp[i]=((dp[i-2]*4)-1)%10007
    print(dp[n])