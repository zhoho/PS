n = int(input())
nCard = list(map(int,input().split()))
m = int(input())
mCard = list(map(int,input().split()))
count = 0
haveCard = [0] * m

for i in nCard:
    if i in mCard:
        mCard_index = mCard.index(i)
        haveCard[mCard_index] += 1
    
print(*haveCard)