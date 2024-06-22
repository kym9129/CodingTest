def solution(a, b):
    answer = 0

    left = min(a,b)
    right = max(a,b)

    for i in range(left, right+1):
        answer += i

    return answer