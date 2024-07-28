croatiaAPlist=['c=','c-','dz=','d-','lj','nj','s=','z=']
croatia=input()
for i in croatiaAPlist:
    croatia=croatia.replace(i,'#')
print(len(croatia))