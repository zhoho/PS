ans = 0

for i in range(5):
    tmp = int(input())

    if tmp < 40:
        tmp = 40

    ans += tmp

print(ans // 5)