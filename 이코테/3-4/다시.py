n,m = map(int,input().split())
ck = 0
while n != 1:
    if n % m == 0:
        n = n//m
    else:
        n -= 1
    ck += 1
print(ck)
