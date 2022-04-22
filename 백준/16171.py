s = input()
k = input()
n = []
for i in s:
    if(65 <= ord(i) < 91 or 97 <= ord(i) < 123):
        n.append(i)

n = ''.join(n)

if k in n:
    print(1)
else:
    print(0)

