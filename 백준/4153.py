while True:
    a = list(map(int,input().split()))
    if sum(a) == 0:
        break
    big_num = max(a)
    a.remove(big_num)
    if a[0] ** 2 + a[1] ** 2 == big_num ** 2:
        print('right')
    else:
        print('wrong')