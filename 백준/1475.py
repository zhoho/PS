n = input()
box = {'0':0, '1':0, '2':0, '3':0, '4':0, '5':0, '6':0, '7':0, '8':0}
for i in range(len(n)):
    if n[i] in ['6', '9']:
        box['6'] += 1
    else:
        box[n[i]] += 1
if box['6'] % 2 == 0:
    box['6'] = box['6'] // 2
else:
    box['6'] = box['6'] // 2 + 1
print(max(box.values()))

