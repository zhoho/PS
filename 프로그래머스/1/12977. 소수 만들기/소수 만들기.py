def solution(nums):
    from itertools import combinations
    import math
    def find(n):
      if n == 1:
        return False
      for i in range(2, int(math.sqrt(n)) + 1):
        if n % i == 0:
          return False
      return True
    count = 0
    a = list(combinations(nums,3))
    comblist = []
    for i in range(len(a)):
      comblist.append(sum(a[i]))
      if find(sum(a[i])) == True:
        count += 1 

    return(count)