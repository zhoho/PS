t = int(input())

for i in range(t):
    p = list(input())
    n = int(input())
    ar = input()[1:-1].split(",")
    plen = len(p)
    errorChk = False
    for j in range(plen):
        if(p[j] == 'R'):
            ar.reverse()
        elif(p[j] == 'D'):
            if(ar == []):
                print("error")
                errorChk = True
            else:
                ar.remove(ar[0])
                j -= 1
    if errorChk == False:
        print(list(ar))
