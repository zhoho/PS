n = int(input())
Ncard = list(map(int,input().split()))
m = int(input())
Mcard = list(map(int,input().split()))

for i in Mcard:
    if i in Ncard:
        print(1,end = ' ')
    else:
        print(0,end = ' ')

#시간초과 이분탐색 공부하기