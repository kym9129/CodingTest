def solution(record):
    answer = []
    
    # 바꾼 닉네임 기록
    nickname_dict = dict()
    for r in record:
        temp_list = r.split()
        status = temp_list[0]
        uid = temp_list[1]
        
        if len(temp_list) == 3:
            nickname_dict[uid] = temp_list[2]
            
    # 메시지 표시
    for r in record:
        temp_list = r.split()
        status = temp_list[0]
        uid = temp_list[1]
        nickname = ''
        if len(temp_list) == 3:
            nickname = temp_list[2]
        if uid in nickname_dict:
            nickname = nickname_dict[uid]
        
        if status == 'Enter':
            answer.append(f'{nickname}님이 들어왔습니다.')
        elif status == 'Leave':
            answer.append(f'{nickname}님이 나갔습니다.')
    
    return answer