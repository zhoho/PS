def solution(s):
    s = s.split()
    answer = []
    for i in range(len(s)):
        if(s[i] == 'Z'):
            answer.append(0)
            answer[i - 1] = 0
        else:
            answer.append(int(s[i]))
    return sum(answer)