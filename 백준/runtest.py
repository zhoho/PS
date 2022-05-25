n = int(input())
cards = sorted(list(map(int,input().split())))

count = {}
for card in cards:
    if card in count:
        count[card] += 1
    else:
        count[card] = 1

print(count)