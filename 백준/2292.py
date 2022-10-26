room = int(input())
n = 6
count = 1
while room > 1:
    count += 1
    room -= n
    n += 6
print(count)
