from itertools import permutations

def operate(num1, num2, o):
    if o == '+':
        return str(int(num1) + int(num2))
    elif o == '-':
        return str(int(num1) - int(num2))
    elif o == '*':
        return str(int(num1) * int(num2))
    
def split_arr(expression):
    arr = list()
    tmp = ''
    for x in expression:
        if x.isdigit():
            tmp += x
        else:
            arr.append(tmp)
            arr.append(x)
            tmp = ''
    
    arr.append(tmp)
    
    return arr
    
def calculate(expression, oprs):
    stmt_arr = split_arr(expression)

    for o in oprs:
        stack = list()
        while len(stmt_arr) > 0:
            tmp = stmt_arr.pop(0)
            if tmp == o:
                stack.append(operate(stack.pop(), stmt_arr.pop(0), o))
            else:
                stack.append(tmp)
                
        stmt_arr = stack
    
    return abs(int(stmt_arr[0]))

def solution(expression):
    
    operands = list()
    # 중복없이 연산자 추출
    for x in expression:
        if x in ['+', '-', '*'] and x not in operands:
            operands.append(x)
        
    # 연산자 우선순위로 perm 생성
    perms = permutations(operands, len(operands))
    
    max_val = 0
    for opr_perm in perms:
        max_val = max(calculate(expression, opr_perm), max_val)
    
    return max_val