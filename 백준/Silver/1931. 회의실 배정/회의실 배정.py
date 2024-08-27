n = int(input())

meet = []

for _ in range(n):
    start, end = map(int, input().split(" "))
    meet.append((start, end))
meet.sort(key=lambda x: (x[1], x[0]))

time = 0
count = 0
for i in meet:
    if time <= i[0]:
        time = i[1]
        count += 1

print(count)