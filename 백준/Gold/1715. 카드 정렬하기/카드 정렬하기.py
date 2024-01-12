import heapq
n=int(input())
cards=[]

for i in range(n):
  heapq.heappush(cards,int(input()))

ans=0
while len(cards)>=2:
  fir_num=heapq.heappop(cards)
  sec_num=heapq.heappop(cards)
  ans+=fir_num+sec_num
  heapq.heappush(cards,fir_num+sec_num)

print(ans)
