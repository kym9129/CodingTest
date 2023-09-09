def solution(clothes):
    # [[이름, 종류], [이름, 종류]]
    
    amap = dict()
    for cloth in clothes:
        item, category = cloth
        amap[category] = amap.get(category, 0) + 1
    
    answer = 1
    for v in amap.values():
        answer *= v + 1
    
    return answer - 1