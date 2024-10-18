def solution(progresses, speeds):
    answer = []
    box = []
    for i in range(len(progresses)):
        if (100 - progresses[i]) % speeds[i] == 0:
            taketime = ((100 - progresses[i]) // speeds[i])
        else:
            taketime = ((100 - progresses[i]) // speeds[i]) + 1
        answer.append(taketime)
    cnt = 1
    high = answer[0]
    # print(answer)
    for i in range(1, len(answer)):
        if high >= answer[i]:
            cnt += 1
        else:
            high = answer[i]
            box.append(cnt)
            cnt = 1
    box.append(cnt)
    return box


## 1. 먼저 몇일 걸리는지 계산 (100 - progress) // speeds + 1 = 걸리는 날
## 2. 내 뒤에 있는 값들이 나보다 작을경우 나보다 클때까지 count + 1해주기