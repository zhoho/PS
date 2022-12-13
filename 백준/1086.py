import sys
input = sys.stdin.readline
n, s = map(int,input().split())
n_list = list(map(int,input().split()))
left, right = 0, 1
ans = []
while right <= n and left <= right:
    q = n_list[left:right]
    total = sum(q)
    if total >= s:
        ans.append(len(q))
        left += 1
    else:
        right += 1
if len(ans) == 0:
    print(0)
else:
    print(min(ans))