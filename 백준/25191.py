chicken = int(input())
cokeAndbeer = list(map(int,input().split()))

Drink_cokeAndbeer = cokeAndbeer[0] // 2 + cokeAndbeer[1]

if(Drink_cokeAndbeer == chicken): print(chicken)
elif(Drink_cokeAndbeer > chicken): print(chicken)
else: print(Drink_cokeAndbeer)