import math

def convert_k_number(n, k):
    k_num = ''
    
    while n > 0:
        k_num = str(n % k) + k_num
        n = n // k
    
    return k_num

def is_prime(n):
    if n == 2 or n == 3:
        return True
    if n % 2 == 0 or n < 2:
        return False
    
    for i in range(3, int(n ** 0.5)+1, 2):
        if n % i == 0:
            return False
    
    return True
        

def get_prime_count(k_num):
    cnt = 0
    for k in k_num.split('0'):
        if k == '':
            continue
        if is_prime(int(k)):
            cnt += 1 
    
    return cnt

def solution(n, k):
    answer = -1
    
    # K진수로 만들기
    k_num = convert_k_number(n, k)
    
    # 소수 찾기
    answer = get_prime_count(k_num)
    
    return answer