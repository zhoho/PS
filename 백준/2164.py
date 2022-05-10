from collections import deque
n = int(input())
box = deque()
count = 0
for i in range (n):
    box.append(i + 1)
while len(box) != 1:
    count += 1
    if count % 2 == 1:
        box.popleft()
    else:
        box.append(box.popleft())
print(box[0])


    