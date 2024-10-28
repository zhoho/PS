n = int(input())
answer = ""
for i in range(1, n+1):
    tmp = ""
    i = str(i)
    for j in range(len(i)):
        if i[j] == "3" or i[j] == "6" or i[j] == "9":
            tmp += "-"
    if tmp == "":
        answer += i + " "
    else:
        answer += tmp + " "
print(answer)
