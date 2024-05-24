n = int(input())
working = []
for _ in range(n):
    name, chk = list(map(str,input().split()))
    if chk != 'leave':
        working.append(name)
    elif chk == 'leave':
        working.remove(name)
working.sort(reverse=True)
for i in range(len(working)):
    print(working[i])
