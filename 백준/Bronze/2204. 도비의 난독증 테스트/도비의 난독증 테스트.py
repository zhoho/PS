while 1:
    words = []
    n = int(input())
    if n == 0:
        break
    for i in range(n):
        word = input()
        words.append(word)
    words.sort(key = lambda word: word.lower())
    print(words[0])
    