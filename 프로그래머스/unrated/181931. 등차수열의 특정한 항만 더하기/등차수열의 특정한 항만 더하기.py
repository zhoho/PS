def solution(a, d, included):
    answer = a
    tolerance = a
    for i in range(len(included)):
        if included[i] == True:
            answer += tolerance
        tolerance += d
    return answer - a