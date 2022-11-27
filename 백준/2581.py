sosu = []
m = int(input())
n = int(input())
for i in range(m,n+1):
    for j in range(2, i+1):
        if j == i:
            sosu.append(i)
        if i % j == 0:
            break
if not sosu:
    print(-1)
else:
    print(sum(sosu))
    print(min(sosu))