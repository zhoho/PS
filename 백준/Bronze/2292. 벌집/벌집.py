room = int(input())
n = 6
count = 1
while room > 1:
    count += 1
    # if room - 1 < 0:
    #     break
    room -= n
    n += 6
    # print(room)
print(count)