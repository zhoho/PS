def solution(arr):
    answer = 0
    arr.sort()
    
    for i in range(arr[-1] ,arr[-1] * arr[-2] * 9999):
        chk = 0
        for j in arr:
            if i % j == 0:
                chk += 1
        if chk == len(arr):
            return i
    return answer