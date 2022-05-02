n = int(input())
a = list(map(int,input().split()))

# aset = set(a)
# a = list(aset) #중복제거 set -> 다시 리스트로 변환

# a.sort()  문제 잘 못이해함
        
dp = [0] * n

# for i in range(n):
#     for j in range(i):
#         if a[i] > a[j]:
#             dp[i] = max(dp[i],dp[j]+1)

# print(max(dp))

for i in range(n):
    for j in range(i):
        print(i, j)
        print("dp[i] : ",dp[i],"dp[j] : ",dp[j])
        print("a[i] : ",a[i], "a[j] : ", a[j])
        if a[i] > a[j] and dp[i] < dp[j]:
            dp[i] = dp[j]
    dp[i] += 1
print(max(dp))