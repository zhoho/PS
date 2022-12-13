import sys
input = sys.stdin.readline
n, s = map(int,input().split())
n_list = list(map(int,input().split()))
left, right = 0, 1
answer = 0
while right <= n and left <= right:
    total = sum(n_list[left:right])
    if total == s:
        answer += 1
        right += 1
    elif total < s:
        right += 1
    else:
        left += 1
print(answer)
