def is_right(p):
    stack = list()
    for x in p:
        if len(stack) > 0:
            if stack[-1] != x:
                stack.pop()
            else:
                stack.append(x)
        else:
            if x == ')':
                return False
            stack.append(x)
    
    if len(stack) == 0:
        return True
    
    return False

def divide_uv(p):
    open_cnt = 0
    close_cnt = 0
    for i in range(len(p)):
        if p[i] == '(':
            open_cnt += 1
        else:
            close_cnt += 1
        
        if open_cnt == close_cnt:
            return p[:i+1], p[i+1:]

def reverse(u):
    s = ''
    for x in u[1:len(u)-1]:
        if x == '(':
            s += ')'
        else:
            s += '('
    
    return s

def solution(p):
    
    # 1
    if p == '':
        return ''
    
    # 2 divide
    u, v = divide_uv(p)
    
    # 3 올바른 괄호 문자열 여부
    if is_right(u):
        # 3-1
        return u + solution(v)
    # 4
    else:
        # 4-1
        answer = '('
        
        # 4-2
        answer += solution(v)
        
        # 4-3
        answer += ')'
        
        # 4-4
        answer += reverse(u)
        
        # 4-5
    return answer