n=int(input())
for i in range(n):
  a=input()
  a_list=list(a)
  cal=0
  
  for i in a_list:
    if i=='(':
      cal+=1
    elif i==')':
      cal-=1
    if cal<0:
      print('NO')
      break
  if cal>0:
    print('NO')
  elif cal==0:
    print('YES')