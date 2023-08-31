def solution(s):

    
    # 순서 찾아내기
    start = 0
    end = 0
    len_map = dict()
    max_len = 0
    for i in range(1, len(s)-1):
        temp_list = list()

        if s[i] == '{':
            start = i+1
        elif s[i] == '}':
            end = i
        
        if start != 0 and end != 0:
            temp_list = list(map(int, s[start:end].split(',')))
            length = len(temp_list)
            len_map[length] = temp_list
            max_len = max(max_len, length)
            start = 0
            end = 0
    
    answer = list()
    for i in range(1, max_len+1):
        for j in len_map[i]:
            if j not in answer:
                answer.append(j)
    
    return answer