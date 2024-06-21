from collections import Counter, defaultdict


def solution(N, stages):
    result_list = list()

    player_cnt = defaultdict(int, Counter(stages))
    print(player_cnt)

    result_list.append({'stage': 0, 'challenger': len(stages), 'fail': 0, 'playing': 0})

    # stage 순회
    for i in range(1, N+2):
        result_dict = dict()

        result_dict['stage'] = i
        result_dict['challenger'] = result_list[i-1]['challenger'] - result_list[i-1]['playing']
        result_dict['playing'] = player_cnt[i]
        
        if result_dict['challenger'] == 0:
            fail = 0

        else:
            fail = result_dict['playing'] / result_dict['challenger']

        result_dict['fail'] = fail
        result_list.append(result_dict)
    
    result_list = result_list[1:N+1]

    result_list = sorted(result_list, key=lambda x: x['fail'], reverse=True)
    # print(sorted_data)
    answer = list()
    for r in result_list:
        answer.append(r['stage'])

    return answer
