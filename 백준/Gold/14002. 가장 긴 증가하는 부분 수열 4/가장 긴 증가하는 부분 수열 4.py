n = int(input())
a = list(map(int,input().split()))

dp = [0] * n
box = []

for i in range(n):
    for j in range(i):
        if a[i] > a[j] and dp[i] < dp[j]:
            dp[i] = dp[j]
    dp[i] += 1
    
chk = max(dp)
print(chk)

for i in range(n - 1, -1 ,-1):
    if dp[i] == chk:
        box.append(a[i])
        chk -= 1
box.reverse()
print(*box)