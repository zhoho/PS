def solution(my_string, is_suffix):
    check = []
    answer = 0
    for i in range(len(my_string)):
        check.append(my_string[i:])
    for i in check:
        if i == is_suffix:
            answer = 1
    return answer