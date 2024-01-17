dwarf = []
for i in range(9):
    dwarf.append(int(input()))
total_dwarf = sum(dwarf)
for i in range(9):
    for j in range(i+1, 9):
        if(total_dwarf-(dwarf[i] + dwarf[j]) == 100):
            fake_dwarf1 = dwarf[i]
            fake_dwarf2 = dwarf[j]

dwarf.remove(fake_dwarf1)
dwarf.remove(fake_dwarf2)
dwarf.sort()
for i in dwarf:
    print(i)
    