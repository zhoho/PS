n,m = map(int,input().split())
ck = 0
while n >= m:
    if n == 1:
        break
    if n % m == 0:
        n = n//m
    else:
        n -= 1
    ck += 1
print(ck)
