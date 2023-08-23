# https://developer-ellen.tistory.com/53

import copy

N, M = map(int, input().split())

room = list()
cctv = list()
for i in range(N):
    row = list(map(int, input().split()))
    room.append(row)

    for j in range(len(row)):
        if row[j] in [1,2,3,4,5]:
            cctv.append([row[j], i, j]) # cctv의 번호와 위치 추가

# 사각지대 최소 크기 구하기. max_cctv = 8

mode = [
    [],
    [[0], [1], [2], [3]],
    [[0, 2], [1, 3]],
    [[0, 1], [1, 2], [2, 3], [3, 0]],
    [[0,1,2], [1,2,3], [2,3,0], [3,0,1]],
    [[0,1,2,3]]
]

# 북동남서
dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]

# 카메라 영역 칠하기
def ray_cast(temp_room, move_case, y, x):
    WALL = 6
    BLIND = 0 # 사각지대
    RAY = 7 # 카메라가 닿는 영역

    for dir in move_case:
        ny = y
        nx = x
        while True:
            ny += dy[dir]
            nx += dx[dir]
            if nx < 0 or nx >= M or ny < 0 or ny >= N:
                break
            if temp_room[ny][nx] == WALL:
                break

            if temp_room[ny][nx] == BLIND:
                temp_room[ny][nx] = RAY

# 좌표 탐색
min_cnt = 2147000000
def dfs(depth, room):
    global min_cnt
    if depth == len(cctv):
        blind_spot_cnt = 0
        for row in room:
            blind_spot_cnt += row.count(0)
        
        min_cnt = min(min_cnt, blind_spot_cnt)
        return

    # cctv 경우의 수 만큼 탐색하면서 카메라 영역 칠하기
    temp_room = copy.deepcopy(room)
    cctv_number, y, x = cctv[depth]
    for move_case in mode[cctv_number]:
        ray_cast(temp_room, move_case, y, x)
        dfs(depth+1, temp_room)
        temp_room = copy.deepcopy(room) # raycast 하고나서 room 초기화

dfs(0, room)
print(min_cnt)