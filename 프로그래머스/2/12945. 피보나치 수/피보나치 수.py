def solution(n):
    answer = 0
    p = [0 for i in range(n + 1)]
    p[0] = 0
    p[1] = 1
    for i in range(2, n + 1):
        p[i] = p[i-1] + p[i-2]
    return p[-1] % 1234567