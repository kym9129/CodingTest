N, L = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(N)]


def check(line):
    for j in range(1, N):
    # 높이 차이가 1을 넘을 경우
        if abs(line[j] - line[j-1]) > 1:
            return False
    
        # 경사 만들기
        # 이전 < 현재 / <-
        elif line[j-1] < line[j]:
            for k in range(L):
                if j-1-k < 0 or line[j-1-k] != line[j-1] or slope[j-1-k]:
                    return False
                if line[j-1-k] == line[j-1]:
                    slope[j-1-k] = True


        # 이전 > 현재 \ ->
        elif line[j-1] > line[j]:
            for k in range(L):
                if j+k >= N or line[j] != line[j+k] or slope[j+k]:
                    return False
                if line[j] == line[j+k]:
                    slope[j+k] = True
    
    return True


# hori
answer = 0
for i in range(N):
    slope = [False] * N
    if check([board[i][j] for j in range(N)]):
        answer += 1

# verti
for i in range(N):
    slope = [False] * N
    if check([board[j][i] for j in range(N)]):
        answer += 1

print(answer)




