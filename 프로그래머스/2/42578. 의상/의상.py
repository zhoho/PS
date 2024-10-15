def solution(clothes):
    answer = 1
    dict = {}
    clen = len(clothes)
    for i in range(clen):
        if clothes[i][1] in dict:
            dict[clothes[i][1]] += 1
        else:
            dict[clothes[i][1]] = 1
    for _, value in dict.items():
        answer *= value + 1
    return answer - 1