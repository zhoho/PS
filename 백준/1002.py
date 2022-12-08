t = int(input())
for i in range(t):
    x1, y1, r1, x2, y2, r2 = map(int,input().split())
    distance = ((x2 - x1) ** 2 + (y2 - y1) ** 2) ** 0.5
    rs = r1 + r2
    rm = abs(r1-r2)
    if distance == 0:
        if r1 == r2:
            print(-1)
        else:
            print(0)
    else:
        if rs == distance or rm == distance: # 내접 또는 외접하는 경우
            print(1)
        elif rm < distance < rs: #두원이 서로 다른 두 점에서 만나는 경우
            print(2)
        else:
            print(0)

# t = int(input())
# for i in range(t):
#     x1, y1, r1, x2, y2, r2 = map(int, input().split())
#     d = ((x2 - x1) ** 2 + (y2 - y1) ** 2) ** 0.5
#     rs = r1 + r2
#     rm = abs(r1 - r2)
#     if d == 0:
#         if r1 == r2:
#             print(-1)
#         else:
#             print(0)
#     else:
#         if d == rs or d == rm:
#             print(1)
#         elif d < rs and d > rm:
#             print(2)
#         else:
#             print(0)