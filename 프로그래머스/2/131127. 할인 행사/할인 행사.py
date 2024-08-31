def solution(want, number, discount):
    answer = 0
    jhbag = []
    for i in range(len(number)):
        for j in range(number[i]):
            jhbag.append(want[i])
    jhbag.sort()
    for i in range(len(discount) - len(jhbag) + 1):
        discount_compare = discount[i:i+10]
        # # discount.sort()
        # print('t--------')
        # print(discount_compare)
        # print(jhbag)
        # print('t--------')
        discount_compare.sort()
        if jhbag == discount_compare:
            answer += 1
    return answer