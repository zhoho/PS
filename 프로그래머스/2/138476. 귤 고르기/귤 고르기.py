from collections import Counter

### 풀이 1 - Counter 이용
def solution(k, tangerine):
    result = 0
    answer = 0
    
    temp = Counter(tangerine)
    temp = temp.most_common()
    
    for i in temp:
        result += i[1]
        answer += 1
        if(result >= k):
            return answer