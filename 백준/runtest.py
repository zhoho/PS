def dongzu(a,b,c):
    A = a
    B = b
    C = c
    aver = (A+B+C)//3
    return aver

while(1):
    a,b,c = map(int,input().split())
    if(a == 0 and c == 0 and c == 0): break
    
    average = dongzu(a,b,c)
    if average >= 80:
        print("평균 : ",average ,"점 합격입니다.")
    else:
        print("평균 : ",average ,"점 뜨거운 합격입니다.")