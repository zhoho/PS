def solution(s):
    total_count = 0
    total_zerocount = 0
    while(len(s) != 1):
        total_count += 1
        zero_count = 0
        for i in s:
            if i == '0':
                zero_count += 1
        total_zerocount += zero_count
        s = exchange(len(s) - zero_count)
    return [total_count, total_zerocount]

def exchange(n):
    result = bin(n)[2:]
    return result