n = int(input())
n_box = list(map(int,input().split()))
key = int(input())

count = [x for x in n_box if x == key]

print(len(count))