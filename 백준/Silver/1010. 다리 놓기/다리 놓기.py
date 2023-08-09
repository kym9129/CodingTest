# https://yoonsang-it.tistory.com/33
t = int(input())
n = m = 0

def factorial(n):
    sum = 1
    for i in range(1, n+1):
        sum *= i
    return sum

for i in range(t):
    n, m = map(int, input().split())
    
    # mCn
    # m! // ( n! * (m-n)! )
    result = factorial(m) // (factorial(n) * factorial(m-n))
    print(result)

