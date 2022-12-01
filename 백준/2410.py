n = int(input())
dp = [0] * (n+1)
dp[0] = 1
muk_su = [2 ** x for x in range(21)]
for i in muk_su:
    for j in range(1, n+1):
        if j - i >= 0:
            dp[j] += dp[j - i]
print(dp[-1] % 1000000000)