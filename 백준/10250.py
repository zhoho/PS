a = int(input())
for i in range(a):
    h, w, n = list(map(int,input().split()))
    floor = n%h
    num = n//h+1
    if n%h == 0:
        floor = h
        num = n//h
    print(floor*100 + num)