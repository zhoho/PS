n = int(input())
box = []
for i in range(n):
    box.append(int(input()))

print(round(sum(box)) / n) #평균값

box.sort()
print(box[n//2+1]) #중앙값

#최빈값
#1.use Counter library
#2. manually

print(box[-1] - box[0]) #범위

