from collections import deque

def solution(maps):
    n = len(maps)
    m = len(maps[0])

    dy = [0,1,0,-1]
    dx = [1,0,-1,0]
    ch = [[0]*m for _ in range(n)]
    dis = [[0]*m for _ in range(n)]
    
    q = deque()
    q.append((0,0))
    
    met_enermy = False
    while q:
        cy, cx = q.popleft()
        for i in range(4):
            ny = cy + dy[i]
            nx = cx + dx[i]
            if 0<=nx<m and 0<=ny<n and maps[ny][nx] == 1:
                if ch[ny][nx] == 0:
                    ch[ny][nx] = 1
                    dis[ny][nx] = dis[cy][cx] +1
                    if ny == n-1 and nx == m-1:
                        met_enermy = True
                        break
                    q.append((ny,nx))
                
    if not met_enermy:
        return -1
    
    return dis[n-1][m-1]+1