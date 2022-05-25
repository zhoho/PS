n = int(input())
Ncard = sorted(list(map(int,input().split())))
m = int(input())
Mcard = list(map(int,input().split()))

dic_count = {}
for card in Ncard:
    if card in count:
        dic_count[card] += 1
    else:
        dic_count[card] = 1

def binary_search(arr, target, start, end):
    if start > end:
        return 0
    mid = (start + end) // 2
    if arr[mid] == target:
        return dic_count.get(target) #what??
    elif arr[mid] < target:
        return binary_search(arr, target, mid + 1, end)
    else:
        return binary_search(arr, target, start, mid - 1)
    

for target in Mcard:
    print(binary_search(Ncard, target, 0, n - 1), end=" ")




