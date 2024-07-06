memo = {}
def get_divisor_cnt(n):
    global memo

    if n in memo:
        return memo[n]

    count = 0
    for i in range(1, int(n**0.5) + 1):
        if n % i == 0:
            count += 1
            if i != n // i:
                count += 1
    
    memo[n] = count
    return count
    
    # nums = []
    # for i in range(1, n+1):
    #     if n % i == 0:
    #         nums.append(i)
    # return len(nums)


def solution(number, limit, power):
    # limit 초과 시 power로

    answer = 0
    for i in range(1, number+1):
        n = get_divisor_cnt(i)
    
        if n > limit:
            n = power
        
        answer += n
    
    return answer