from collections import deque

def solution(queue1, queue2):
    answer = -1
    
    # 합이 큰 큐 -> 작은 큐로 옮김
    
    # 합이 같아질 때 까지 옮기기 반복
    # count가 limit에 도달할 때 까지 합이 같아지지 않으면 -1 리턴하고 끝냄
    
    q1 = deque(queue1)
    q2 = deque(queue2)
    
    tot1 = sum(queue1)
    tot2 = sum(queue2)
    
    count = 0
    while count < len(queue1) * 4:
        if tot1 < tot2:
            n = q2.popleft()
            q1.append(n)
            
            tot1 += n
            tot2 -= n
            count += 1
        
        elif tot1 > tot2:
            n = q1.popleft()
            q2.append(n)
            
            tot1 -= n
            tot2 += n
            count += 1
        
        else: # 합 같음
            return count
        
    return answer