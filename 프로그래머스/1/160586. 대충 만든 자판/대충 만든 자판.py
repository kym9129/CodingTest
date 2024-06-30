def get_least_idx(keymap, alphabet):
    min_cnt = 2147000000
    result = -1
    for key in keymap:
        if alphabet not in key:
            continue
        cnt = key.index(alphabet)

        if cnt < min_cnt:
            min_cnt = cnt
            result = cnt+1
    
    return result

def solution(keymap, targets):
    answer = []

    for target in targets:
        t_sum = 0
        for t in target:
            idx = get_least_idx(keymap, t)
            if idx == -1:
                t_sum = -1
                break
            t_sum += idx
        
        answer.append(t_sum)

    return answer