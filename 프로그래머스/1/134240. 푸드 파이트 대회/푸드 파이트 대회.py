def solution(food):
    result = ''
    for i in range(1, len(food)):
        cnt = food[i]

        if cnt % 2 != 0:
            cnt -= 1
        
        if cnt <= 0:
            continue

        for _ in range(cnt // 2):
            result += str(i)
    
    result += '0'

    for j in range(len(result)-2, -1, -1):
        result += str(result[j])

    return result