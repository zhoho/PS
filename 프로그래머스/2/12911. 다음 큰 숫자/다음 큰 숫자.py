def solution(n):
    check = bin(n)[2:].count('1')
    answer = 0
    for x in range(n+1, 1000001):
        if bin(x)[2:].count('1') == check:
            answer = x
            break
    return answer