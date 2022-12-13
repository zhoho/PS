n = int(input())
a = 0
b = 0
c = 0
if n >= 300:
    q = n // 300 
    a += q
    n -= (300 * q)
if n >= 60:
    q = n // 60
    b += q
    n -= (60 * q)
if n >= 10:
    q = n // 10
    c += q
    n -= (10 * q)
if 0 < n < 10:
    print(-1)
else:
    print(a, b, c)