t = int(input())
for _ in range(t):
    n = int(input())
    apply = []
    for i in range(n):
        doc, meet = map(int, input().split())
        apply.append((doc, meet))
    
    apply.sort(key=lambda x: x[0])
    
    count = 1
    min_meet = apply[0][1]
    
    for i in range(1, n):
        if apply[i][1] < min_meet:
            count += 1
            min_meet = apply[i][1]
    
    print(count)
