def solution(my_string, is_prefix):
    for i in range(1, len(my_string)):
        if is_prefix == my_string[:i]:
            return 1
    return 0