def solution(n):
    answer = 0
    if n % 2 == 1:
        for i in range(n + 1):
            if i % 2 == 1:
                answer += i
    else:
        for i in range(n + 1):
            if i % 2 == 0:
                answer += i * i
    return answer


# 7 = 1 3 5 7 = 16
# 6 = 2 4 6 = 12
# 5 = 1 3 5 = 9
# 4 = 2 4 = 6