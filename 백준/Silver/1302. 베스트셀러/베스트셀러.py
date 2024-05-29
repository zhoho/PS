n = int(input())
d = {}

for i in range(n):
    book = input()
    if book in d:
        d[book] += 1
    else:
        d[book] = 1
max = max(d.values())
ans = []

for key, value in d.items():
    if value == max:
        ans.append(key)
ans = sorted(ans)
print(ans[0])

