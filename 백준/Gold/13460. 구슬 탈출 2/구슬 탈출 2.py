# 참고 : https://wlstyql.tistory.com/72

n, m = map(int, input().split())
board = [list(input().rstrip()) for _ in range(n)]
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
queue = list()

# visited[rx][ry][bx][by]
visited = [[[[False] * m for _ in range(n)] for _ in range(m)] for _ in range(n)]


def move(x, y, dx, dy):
    cnt = 0
    while board[x+dx][y+dy] != '#' and board[x][y] != 'O':
        x += dx
        y += dy
        cnt += 1
    return x, y, cnt
    

def bfs():
    while queue:
        rx, ry, bx, by, depth = queue.pop(0)
        if depth > 10:
            break
        for i in range(4):
            nrx, nry, rcnt = move(rx, ry, dx[i], dy[i])
            nbx, nby, bcnt = move(bx, by, dx[i], dy[i])
            if board[nbx][nby] != 'O': # 파란공이 구멍이 아닐 때
                if board[nrx][nry] == 'O': # 성공
                    print(depth)
                    return
                
                elif nrx == nbx and nry == nby: # 파란빨간공 겹칠 때
                    if rcnt < bcnt:
                        nbx -= dx[i]
                        nby -= dy[i]
                    else:
                        nrx -= dx[i]
                        nry -= dy[i]
            
            # 방문 처리
            if not visited[nrx][nry][nbx][nby]:
                visited[nrx][nry][nbx][nby] = True
                # 다음 탐색
                queue.append((nrx, nry, nbx, nby, depth+1))
                
    print(-1)


def solve():
    rx, ry, bx, by = 0, 0, 0, 0
    # 구슬 시작점 찾기
    for i in range(n):
        for j in range(m):
            if board[i][j] == 'R':
                rx, ry = i, j
            elif board[i][j] == 'B':
                bx, by = i, j
    depth = 1
    queue.append((rx, ry, bx, by, depth))
    visited[rx][ry][bx][by] = True
    
    bfs()

solve()