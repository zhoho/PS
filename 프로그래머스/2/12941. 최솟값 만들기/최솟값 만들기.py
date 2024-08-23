def solution(A,B):
    answer = 0
    
    # A,B 정렬하고 A에서 가장 작은 숫자 X B에서 가장 큰 숫자 
    # A는 오름차순 정렬, B는 내림차순 정렬
    A.sort()
    B.sort(reverse=True)
    
    for i in range(len(A)):
        answer += (A[i] * B[i])

    return answer