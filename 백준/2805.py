n, m = map(int, input().split())
trees = list(map(int,input().split()))
startPoint = 1
endPoint = max(trees)
total = 0

while startPoint <= endPoint:
    mid = (startPoint + endPoint) // 2
    total = 0
    for i in trees:
        if i >= mid:
            total += i - mid
    
    if total >= m:
        startPoint = mid + 1
    else:
        endPoint = mid - 1
print(endPoint)