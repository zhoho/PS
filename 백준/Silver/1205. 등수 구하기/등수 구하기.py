n, new_score, p = map(int, input().split())

if n == 0:
    ans = 1
else:
    rank = list(map(int, input().split()))

    if n < p:
        rank.append(new_score)
        rank.sort(reverse=True)
        ans = rank.index(new_score) + 1
    elif n == p:
        if rank[-1] >= new_score:
            ans = -1 
        else:
            rank.append(new_score)
            rank.sort(reverse=True)
            ans = rank.index(new_score) + 1

print(ans)
