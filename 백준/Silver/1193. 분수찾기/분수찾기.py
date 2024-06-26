n=1
num=0
numSum=0
x=int(input())
while 1:
    if x<=num:
        break
    else:
        num+=n
        n+=1
for i in range(n-1):
    numSum+=i
h=x-numSum
if n%2==1:
    print(str(h)+"/"+str(n-h))
elif n%2==0:
    print(str(n-h)+"/"+str(h))