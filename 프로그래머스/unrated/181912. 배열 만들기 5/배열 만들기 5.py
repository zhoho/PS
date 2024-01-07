def solution(intStrs, k, s, l):
    answer = []
    for i in intStrs:
        if int(i[s:l+s]) > k:
            answer.append(int(i[s:l+s]))
    return answer