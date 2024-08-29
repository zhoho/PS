n = int(input())
nums = list(map(int, input().split()))
nums.sort()
count = 0

for k in range(n):
    i = 0
    j = n - 1
    while i < j:
        if i == k:
            i += 1
            continue
        if j == k:
            j -= 1
            continue
        
        if nums[i] + nums[j] == nums[k]:
            count += 1
            break
        elif nums[i] + nums[j] < nums[k]:
            i += 1
        else:
            j -= 1

print(count)