def binary_tree(target, sang_card):
    left = 0
    rigth = len(sang_card) - 1
    while(left <= rigth):
        mid = (left + rigth) // 2
        if sang_card[mid] == target:
            return 1
        elif sang_card[mid] > target:
            rigth = mid - 1
        else:
            left = mid + 1
    return 0


n = int(input())
sang_card = list(map(int,input().split()))
m = int(input())
compare_card = list(map(int,input().split()))

sang_card.sort()

for target in compare_card:
    print(binary_tree(target, sang_card))