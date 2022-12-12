a, b = map(int,input().split())
n = int(input())
n_list = []
q = abs(a-b)
ans = []
for _ in range(n):
    n_list.append(int(input()))
for i in n_list:
    ans.append(abs(i-b))
ans.append(q)
if min(ans) == q:
    print(q)
else:
    print(min(ans)+1)