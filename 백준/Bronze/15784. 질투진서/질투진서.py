n, a, b = list(map(int,input().split()))
seat = []
vsjs = []
for i in range(n):
    seat = input().split()
    vsjs.append(seat[b-1])
    if(i == a - 1):
        js = seat[b-1]
        vsjs.append(max(seat))
if(js >= max(vsjs)):
    print("HAPPY")
else:
    print("ANGRY")