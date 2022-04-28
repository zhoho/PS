n, k = list(map(int,input().split()))
a = list(map(int,input().split()))
ans = 0
max_ans = 0

for i in range(n):
    if ans >= max_ans:
        max_ans = ans
        ans = 0
    for j in range(k):
        ans += a[i+j-1]

print(max_ans)

### 틀림 슬라이딩 윈도우 알고리즘 이용해서 다시풀기! 
### 런타임에러