words = input()
stack = []
reverse_stack = []
for i in words:
    if i == '.':
        break
    elif i == '(' or '[':
        stack.append(i)
    elif stack[-1] == '[' and i == ']':
        stack.pop()
    elif stack[-1] == '(' and i == ')':
        stack.pop()
if stack.isEmpty():
    print('yes')
else:
    print('no')

        
