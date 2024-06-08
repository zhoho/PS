i=1
ans_list=[]
L=P=V=1
while 1:
  L,P,V=list(map(int,input().split()))
  if L==0 or P==0 or V==0:
      break
  else:
    ans_list.append(int((V//P)*L+min((V%P),L)))
    i+=1
for i in range(len(ans_list)):
    print("Case",str(i+1)+':',ans_list[i])
  
