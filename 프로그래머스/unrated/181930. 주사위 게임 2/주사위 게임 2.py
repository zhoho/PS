def solution(a, b, c):
    answer = 0
    if a==b==c:
        answer = (3*a) * (3*a*a) *(3*a*a*a)
    elif a!=b and b!=c and a!=c:
        answer = a+b+c
    else:
        answer = (a+b+c) * ((a*a)+(b*b)+(c*c))
    return answer