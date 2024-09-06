def solution(n):
    ans = 1
    
    # [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    while(n != 1):
        if n % 2 == 0:
            n = n // 2
        else:
            n = (n - 1) // 2
            ans += 1
    return ans