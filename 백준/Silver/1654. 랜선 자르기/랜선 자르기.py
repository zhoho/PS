import sys
input=sys.stdin.readline
k,n=list(map(int,input().split()))
data=[int(input()) for _ in range(k)]

left,right=1,max(data)
result=0
while left<=right:
    total=0
    mid=(left+right)//2
    for i in data:
        total+=i//mid
    if total>=n:
        left=mid+1
        result=mid
    else:
        right=mid-1
print(result)