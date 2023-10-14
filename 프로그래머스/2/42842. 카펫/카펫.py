def solution(brown, yellow):
    
    total_cnt = brown+yellow
    
    # get ratio
    for h in range(3, total_cnt):
        w = total_cnt // h

        if w >= h and yellow == (w-2) * (h-2):
            return [w, h]
    
    answer = []
    return answer