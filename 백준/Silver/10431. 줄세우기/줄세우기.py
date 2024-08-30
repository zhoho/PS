n = int(input())
for _ in range(n):
    t = list(map(int, input().split()))
    ans = 0
    for i in range(1, len(t) - 1):
        for j in range(i + 1, len(t)):
            if t[i] > t[j]:
                t[i], t[j] = t[j], t[i]
                ans += 1
    print(t[0], ans)