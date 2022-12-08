n, m = map(int,input().split())
icecream = list(map(int,input().split()))
ans = []
mint_check = 0
for i in range(m):
    check = icecream.index(max(icecream))
    if icecream[check] % 7 == 0:
        mint_check += 1
    if mint_check % 2 == 0:
        ans.append(check+1)
        icecream[check] = 0
    else:
        ans.append(check+1)
        icecream[check] = 0
        check = n - (check + 1)
    print("check :", check+1)
    print("icecream :", icecream)
    print("ans :", ans)
print(ans)