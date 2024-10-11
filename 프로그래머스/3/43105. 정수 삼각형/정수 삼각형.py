# def solution(triangle):
#     n = len(triangle)
#     dp = [[0] * (n+1) for _ in range(n+1)]
#     dp[1][1] = triangle[0][0]
#     for i in range(1, n+1):
#         for j in range(1, i+1):
#             dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + triangle[i-1][j-1]
#     return max(dp[-1])



def solution(triangle):
    n = len(triangle)
    dp = [[0] * (n+1) for _ in range(n+1)]
    # print(dp)
    dp[1][1] = triangle[0][0]
    for i in range(1, n + 1):
        for j in range(1, i + 1):
            dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + triangle[i-1][j-1]
    return max(dp[-1])