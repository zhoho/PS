def solution(s):
    stack = []
    
    for i in range(len(s)):
        if not stack:
            stack.append(s[i])
            continue
        top = stack[-1]
        if s[i] == top:
            stack.pop()
        else:
            stack.append(s[i])
    if not stack:
        return 1
    return 0