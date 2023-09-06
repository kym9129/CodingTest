from collections import deque


dy = [0, 1, 0, -1]
dx = [1, 0, -1, 0]

def bfs(place):

    start = list()
    for i in range(len(place)):
            for j in range(len(place[i])):
                if place[i][j] == 'P':
                    start.append([i, j])

    for s in start:

        visited = [[0]*5 for _ in range(5)]
        visited[s[0]][s[1]] = 1

        distance = [[0]*5 for _ in range(5)]
        
        q = deque([s])
        while q:
            cy, cx = q.popleft()
            
            for i in range(4):
                ny = cy + dy[i]
                nx = cx + dx[i]
                
                if ny >= 0 and ny < 5 and nx >= 0 and nx < 5 and visited[ny][nx] == 0:
                    if place[ny][nx] == 'O':
                        q.append([ny, nx])
                        visited[ny][nx] = 1
                        distance[ny][nx] = distance[cy][cx] + 1
                        
                    elif place[ny][nx] == 'P' and distance[cy][cx] <= 1:
                        return 0
    
    return 1
        

def solution(places):
    answer = []
    
    for place in places:
        answer.append(bfs(place))
    
    return answer