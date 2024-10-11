def solution(operations):
    answer = []
    n = len(operations)
    for i in operations:
        if i == "D 1":
            if len(answer) != 0:
                answer.remove(max(answer))
        elif i == "D -1":
            if len(answer) != 0:
                answer.remove(min(answer))
        else:
            tmp = i[2::]
            answer.append(int(tmp))
    if len(answer) == 0:
        return [0,0]
    answer.sort(reverse=True)
    a = int(answer[0])
    b = int(answer[-1])
    return [a,b]