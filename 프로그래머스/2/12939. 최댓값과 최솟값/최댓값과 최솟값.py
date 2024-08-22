def solution(s):
    # 1. 공백을 기준으로 숫자 나누기 -> 배열로 저장
    # 2. min, max 최솟값과 최댓값 구분하기
    # 3. str 형태로 출력하기
    
    split_s = list(map(int, s.split(" ")))
    min_num = min(split_s)
    max_num = max(split_s)
    
    
    
    return str(min_num) + " " + str(max_num)