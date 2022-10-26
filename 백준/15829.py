n = int(input())
words = input()
m = 1234567891
r = 31
ans = 0

for i in range(n):
    ans += (ord(words[i]) - 96) * (r ** i)
 
print(ans % m)

