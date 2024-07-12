
def get_head(n, board):
    head = tuple()
    found = False
    for x in range(n):
        for y in range(n):
            if board[x][y] == '*':
                head = (x, y)
                found = True
                break
        if found:
            break
    
    return head

def get_heart(head):
    x, y = head
    return (x+1, y)

def get_arm(type, heart, board, n):

    cnt = 0
    x, y = heart
    for i in range(1, n):
        if type == 'left':
            i *= -1
        
        ny = y+i
        if ny >= n or ny < 0:
            break

        if board[x][ny] != '*':
            break
    
        if board[x][ny] == '*':
            cnt += 1
    
    return cnt

# 허리 : 심장위치부터 x+1씩 탐색. 마지막 포지션 기억 a, b
def get_waist(heart, n):
    x, y = heart
    cnt = 0
    waist_pos = tuple()
    for i in range(1, n):
        nx = x + i

        if nx >= n or nx < 0:
            break

        if board[nx][y] != '*':
            break

        if board[nx][y] == '*':
            waist_pos = (nx, y)
            cnt += 1

    # return 길이, 위치
    return cnt, waist_pos

# 왼다리 : a+1 b-1부터 cnt=1 깔고 시작. a+1씩 탐색
# 오른다리 : a+1 b+1부터 cnt=1깔고 시작. a+1씩 탐색

def get_leg(type, waist_pos, board, n):
    a, b = waist_pos

    move = -1
    if type == 'right':
        move = 1
    
    b += move
    
    cnt = 0
    for i in range(1, n):
        na = a+i

        if na < 0 or na >= n or b < 0 or b >= n:
            break

        if board[na][b] != '*':
            break

        if board[na][b] == '*':
            cnt += 1
    
    return cnt


n = int(input())
board = [ list(input()) for _ in range(n)]
# print(board)

head = get_head(n, board)
heart = get_heart(head)
left_arm = get_arm('left', heart, board, n)
right_arm = get_arm('right', heart, board, n)
waist_cnt, waist_pos = get_waist(heart, n)
left_leg = get_leg('left', waist_pos, board, n)
right_leg = get_leg('right', waist_pos, board, n)


# 심장의 위치와 팔(왼/오), 다리(왼/오), 허리의 길이를 구하여라.
print(f'{heart[0]+1} {heart[1]+1}')
print(f'{left_arm} {right_arm} {waist_cnt} {left_leg} {right_leg}')