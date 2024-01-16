n = int(input())
arr = []
new_arr = []

for i in range(n):
    arr.append(int(input()))       
arr.sort()

for i in arr:
    if i not in new_arr:
        new_arr.append(i)

for i in arr:
    print(i)