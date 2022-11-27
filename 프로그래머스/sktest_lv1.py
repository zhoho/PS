commands = [[2, 5, 3], [4, 4, 1], [1, 7, 3]]
answer = []
for i in range(3):
    array = [1, 5, 2, 6, 3, 7, 4]
    newarray = [0]
    newarray = array[commands[i][0]-1:commands[i][1]]
    print(array)
    newarray.sort()
    print('newarr', newarray)
    answer.append(newarray[commands[i][2]-1])

print(answer)