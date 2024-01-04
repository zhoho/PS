def solution(my_string, s, e):
    answer = ''
    rev_answer = ''
    answer += my_string[s:e + 1]
    for i in answer:
        rev_answer = i + rev_answer
    answer = my_string[0:s] + rev_answer + my_string[e + 1:]
    
    return answer