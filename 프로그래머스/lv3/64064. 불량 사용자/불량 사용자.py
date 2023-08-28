from itertools import permutations

def check(user, ban):
    if len(user) != len(ban):
        return False
    
    for a, b in zip(user, ban):
        if b == '*':
            continue
        if a != b:
            return False
    
    return True

def solution(user_id, banned_id):
    answer = list() # 경우의수 순열 넣을 리스트
    
    for perm in permutations(user_id, len(banned_id)):
        count = 0
        for user, ban in zip(perm, banned_id):
            if check(user, ban):
                count += 1
        
        if count == len(banned_id):
            if set(perm) not in answer:
                answer.append(set(perm)) # 제재아이디 케이스 순열에 해당할 경우 추가
    
    return len(answer)