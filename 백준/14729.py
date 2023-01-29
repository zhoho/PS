import sys
input = sys.stdin.readline
n = int(input())
WhowannagototheLab = []
for i in range(n):
    WhowannagototheLab.append(input())
WhowannagototheLab.sort()
for j in range(7):
    print(WhowannagototheLab[j])
