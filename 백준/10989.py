n = int(input())
box = []
for i in range (n):
    box.append(int(input()))
box.sort()
for i in range(n):
    print(box[i])

