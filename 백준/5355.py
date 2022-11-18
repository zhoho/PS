from ast import operator


n = int(input())

for _ in range(n):
    jj = input().split(' ')
    num = float(jj[0])
    operators = jj[1:]

    for i in operators:
        if i == '@':
            num *= 3
        elif i == '%':
            num += 5
        else:
            num -= 7
    print("%0.2f" % num)