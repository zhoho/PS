n = int(input())
tlist = list(map(int,input().split()))
t, p = map(int,input().split())
tsum = 0
for i in tlist:
    if i == 0:
        tsum += 0
    elif i // t == 0:
        tsum += 1
    elif i % t != 0:
        tsum += i // t + 1
    else:
        tsum += i // t

print(tsum)
print(n//p, n%p)