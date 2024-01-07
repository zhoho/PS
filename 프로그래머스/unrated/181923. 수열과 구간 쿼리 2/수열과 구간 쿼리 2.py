def solution(arr, queries):
    result = []
    answer = []
    for i, j, h in queries:
        for a in range(j+1):
            if i<=a<=j:
                if arr[a]>h:
                    result.append(arr[a])
        if result != []:
            answer.append(min(result))
        else:
            answer.append(-1)
        result = []
    return answer