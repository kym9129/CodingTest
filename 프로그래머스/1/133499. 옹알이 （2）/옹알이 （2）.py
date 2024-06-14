def solution(babbling):
    cnt = 0
    for b in babbling:
        cans = ['aya', 'ye', 'woo', 'ma']
        
        iterate_done = False
        just_deleted = ''
        while iterate_done == False:
            for i, can in enumerate(cans):
                if len(b) >= len(can) and b[:len(can)] == can and just_deleted != can:
                    b = b[len(can):]
                    just_deleted = can
                    break
                
                if i == len(cans) - 1:
                    iterate_done = True
        
        if len(b) == 0:
            cnt += 1
    
    return cnt