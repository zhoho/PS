n = int(input())
nlist = list(map(int,input().split()))
nlist = list(set(nlist))
nlist = sorted(nlist)

print(*nlist)