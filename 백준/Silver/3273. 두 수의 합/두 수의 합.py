import sys
input = sys.stdin.readline
n = int(input())
n_list = sorted(list(map(int,input().split())))
x = int(input())
answer = 0
left, right = 0, n-1
while left < right:
    t = n_list[left] + n_list[right]
    if t == x:
        answer += 1
        left += 1
    elif t < x:
        left += 1
    else:
        right -= 1
print(answer)