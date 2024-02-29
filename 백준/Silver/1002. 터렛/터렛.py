t = int(input())
for i in range(t):
    x1, y1, r1, x2, y2, r2 = map(int,input().split())
    distance = ((x1-x2)**2 + (y1-y2)**2)**0.5
    rs = r1 + r2
    rm = abs(r1-r2)
    if distance == 0:
        if r1 == r2:
            print(-1)
        else:
            print(0)
    else:
        if distance == rs or distance == rm:
            print(1)
        elif rm < distance < rs:
            print(2)
        else:
            print(0)