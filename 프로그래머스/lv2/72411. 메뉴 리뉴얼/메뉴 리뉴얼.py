from itertools import combinations
from collections import Counter

def solution(orders, course):
    answer = []
    
    # 조합 만들기. r은 course의 요소만큼만.
    # orders 탐색해서 카운팅. {조합 : count}
    # count 2 이상인 것들만 추출?
    
    for c in course:
        temp = list()
        for order in orders:
            combi = combinations(sorted(order), c)
            temp += combi
        
        counter = Counter(temp)
        if len(counter) > 0:
            max_cnt = max(counter.values())
            for key in counter:
                if counter[key] == max_cnt and max_cnt > 1:
                    answer.append(''.join(key))
        
    return sorted(answer)