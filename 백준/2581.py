sosu = []
m = int(input())
n = int(input())
for i in range(m,n):
    check = 0
    for j in range(2, i):
        if i % j == 0:
            check += 1
    if check == 0:
        sosu.append(i)
print(sosu)
print(sum(sosu))
print(min(sosu))