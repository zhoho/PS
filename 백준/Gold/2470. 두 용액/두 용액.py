n = int(input())
water = list(map(int, input().split()))
water.sort() 

left = 0
right = n - 1
min_sum = 2e+9+1
answer = [0, 0]

while left < right:
    curr_sum = water[left] + water[right]
    
    if abs(curr_sum) < min_sum:
        min_sum = abs(curr_sum)
        answer[0] = water[left]
        answer[1] = water[right]
    
    if curr_sum < 0:
        left += 1
    else:
        right -= 1

print(*sorted(answer))