from collections import deque
import sys

box = deque()
n = int(input())
for i in range(n):
    # tmp = list(input().split())
    tmp = sys.stdin.readline().split()
    if tmp[0] == 'push_front':
        box.appendleft(tmp[1])
    elif tmp[0] == 'push_back':
        box.append(tmp[1])
    elif tmp[0] == 'pop_front':
        if len(box) == 0:
            print(-1)
        else:
            print(box.popleft())
    elif tmp[0] == 'pop_back':
        if len(box) == 0:
            print(-1)
        else:
            print(box.pop())
    elif tmp[0] == 'size':
        print(len(box))
    elif tmp[0] == 'empty':
        if len(box) == 0:
            print(1)
        else:
            print(0)
    elif tmp[0] == 'front':
        if len(box) == 0:
            print(-1)
        else:
            print(box[0])
    elif tmp[0] == 'back':
        if len(box) == 0:
            print(-1)
        else:
            print(box[-1])




# push_front X: 정수 X를 덱의 앞에 넣는다.
# push_back X: 정수 X를 덱의 뒤에 넣는다.
# pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
# pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
# size: 덱에 들어있는 정수의 개수를 출력한다.
# empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
# front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
# back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.