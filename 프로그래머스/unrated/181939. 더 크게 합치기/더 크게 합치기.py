def solution(a, b):
    aFirst = int(str(a) + str(b))
    bFirst = int(str(b) + str(a))
    answer = bFirst
    if(aFirst > bFirst):
        answer = aFirst
    return answer