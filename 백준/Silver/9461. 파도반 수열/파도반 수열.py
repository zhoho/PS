T = int(input())
dp = [0] * 101
dp[0] = 1
dp[1] = 1
dp[2] = 1
dp[3] = 2
for _ in range(T):
    N = int(input())
    for i in range(4, N+1):
        dp[i] = dp[i-3] + dp[i-2]
    print(dp[N-1])