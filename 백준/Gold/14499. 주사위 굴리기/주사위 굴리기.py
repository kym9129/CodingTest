# https://hongcoding.tistory.com/128

n, m, x, y, k = map(int, input().split())
board = list()
for _ in range(n):
    board.append(list(map(int, input().split())))

cmd_list = list(map(int, input().split()))

dice = [0] * 6
dx = [0, 0, -1, 1] # 동 서 북 남
dy = [1, -1, 0, 0]

def role_dice(dir):
    EAST = 0
    WEST = 1
    NORTH = 2
    SOUTH = 3

    a, b, c, d, e, f = dice[0], dice[1], dice[2], dice[3], dice[4], dice[5]

    if dir == EAST:
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = d, b, a, f, e, c

    elif dir == WEST:
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = c, b, f, a, e, d
    elif dir == NORTH:
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = e, a, c, d, f, b
    elif dir == SOUTH:
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = b, f, c, d, a, e



def move(x, y, dir):
    return (x + dx[dir], y + dy[dir])

top = 1
bottom = 6
for cmd in cmd_list:

    nx, ny = move(x, y, cmd-1)
    # 지도 벗어나면 넘어감. 출력X
    if nx < 0 or nx >= n or ny < 0 or ny >= m:
        continue

    role_dice(cmd-1)
    TOP = 0
    BOTTOM = 5

    if board[nx][ny] == 0:
        board[nx][ny] = dice[BOTTOM]
    
    else:
        dice[BOTTOM] = board[nx][ny]
        board[nx][ny] = 0
    
    print(dice[TOP])

    x = nx
    y = ny