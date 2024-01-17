def solution(N, stages):
    answer = []
    result = []
    stages.sort()
    total_users = len(stages)
    for i in range(1, N + 1):
        if stages.count(i) == 0:
            answer.append([i, 0])
        else:
            answer.append([i, (stages.count(i)/total_users)])
            total_users -= stages.count(i)
    answer.sort(key=lambda x:(-x[1],x[0]))
    for i in answer:
        result.append(i[0])
    return result