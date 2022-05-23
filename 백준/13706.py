# import math
# n = int(input())
# print(int(math.sqrt(n)))

n = int(input())
low = 1
high = n

while 1:
    mid = (low + high) // 2
    if mid ** 2 == n:
        print(mid)
        break
    elif mid ** 2 < n:
        low = mid + 1
    else:
        high = mid - 1