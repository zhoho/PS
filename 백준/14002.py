
# 땡땡 나중에 다시 풀기
# 땡땡 나중에 다시 풀기

n = int(input())
a = list(map(int,input().split()))
dp = [0] * n
box = []

for i in range(n):
    for j in range(i):
        if a[i] > a[j] and dp[i] < dp[j]:
            dp[i] = dp[j]
            # box[i][j] += a[i]
    dp[i] += 1

print(max(dp))
print(dp)

chk = max(dp)

for i in range(n - 1, -1 ,-1): # n-1 부터 -1 까지 -1씩 감소
    if dp[i] == chk:
        box.append(a[i])
        chk -= 1
box.reverse()
print(box)
