# factorial practice
n = int(input())

# 반복적으로 구현


def factorial_iterative(n):
    result = 1
    for i in range(1, n + 1):
        result *= i
    return result

# 재귀적으로 구현


def factorial_recursion(n):
    if n <= 1:
        return 1
    return n * factorial_recursion(n - 1)


print(factorial_recursion(n))
# print(factorial_iterative(n))
