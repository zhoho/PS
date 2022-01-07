n = []
check = 0
check1 = 0
for i in range(10):
    n.append(int(input()))
    check += n[i]
    if check >= 100:
        check1 = check - n[i]
        break
if (check - 100 <= 100 - check1):
    print(check)
else:
    print(check1)