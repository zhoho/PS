### 풀이 2 dict 사용, 
## 핵심 key 
## a = dict(sorted(a.items(), key = lambda x:x[1], reverse = True))
def solution(k, tangerine):
    answer = 0
    dic = {}
    for i in tangerine:
        if i in dic:
            dic[i] += 1
        else:
            dic[i] = 1
    dic = dict(sorted(dic.items(), key = lambda x:x[1], reverse = True))    
    for i in dic:
        if k <= 0:
            return answer
        k-=dic[i]
        answer+=1        
    return answer
# from collections import Counter

# ### 풀이 1 - Counter 이용
# def solution(k, tangerine):
#     result = 0
#     answer = 0
    
#     temp = Counter(tangerine)
#     temp = temp.most_common()
    
#     for i in temp:
#         result += i[1]
#         answer += 1
#         if(result >= k):
#             return answer
