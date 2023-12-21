def solution(a, b):
    answer = 0
    ab = int(str(a) + str(b))
    xab = 2 * a * b
    answer = ab
    if(xab > answer):
        answer = xab
    return answer