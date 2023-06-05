def solution(x):
    
    str_x = str(x)
    sum = 0
    for s in str_x:
        sum += int(s)
    
    return x % sum == 0