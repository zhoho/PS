## x가 0이면 배열에서 가장 작은 값 출력 후 제거, 이후 
import sys
import heapq
n = int(input())

heap = []

for i in range(n):
    x = int(sys.stdin.readline())
    if x == 0:
        if len(heap) == 0:
            print(0)
        else:
            print(heapq.heappop(heap))
    else:
        heapq.heappush(heap, x)