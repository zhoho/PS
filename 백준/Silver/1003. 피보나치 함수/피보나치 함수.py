n=int(input())

zero=[0]*100
one=[0]*100
m=[0,0,0]
summ=[]
zero[0]=1;one[0]=0;zero[1]=0;zero[2]=1;one[1]=1;one[2]=1
for i in range(n):
  mnum=int(input())
  m.append(mnum)
  for i in range(3,m[i+3]+1):
    zero[i]=zero[i-1]+zero[i-2]
    one[i]=one[i-1]+one[i-2]
m=m[3:]
for i in m:
  print(zero[i],one[i])