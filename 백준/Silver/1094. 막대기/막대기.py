stick = 64
stick_len_x= int(input())
short_stick = stick
stick_box = [stick]
while(1):
    if(sum(stick_box) <= stick_len_x):
        break
    short_stick = min(stick_box)
    stick_box.remove(short_stick)
    short_stick /= 2
    stick_box.append(short_stick)
    stick_box.append(short_stick)
    if(sum(stick_box) - short_stick >= stick_len_x):
        del(stick_box[-1])
print(len(stick_box))


