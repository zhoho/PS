n = int(input())
nums = []
for i in range(n):
    nums.append(int(input()))

#1.mean
mean = round(sum(nums)/n)
print(mean)
#2.median
nums.sort()
median = nums[n//2]
print(median)
#3.mode
dic = dict()
for i in nums:
    if i in dic:
        dic[i] += 1
    else:
        dic[i] = 1

maxinum_mode_value = max(dic.values())
max_mode_list = []

for i in dic:
    if dic[i] == maxinum_mode_value:
        max_mode_list.append(i)

if len(max_mode_list) != 1:
    print(max_mode_list[1])
else:
    print(max_mode_list[0])
#4.range
range = nums[-1] - nums[0]
print(range)