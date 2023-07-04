n = int(input())

move_list = list()

def hanoi(length, from_pos, to_pos, other_pos):
    if length == 0:
        return
    hanoi(length-1, from_pos, other_pos, to_pos) # 1. 가장 큰 원반 빼고 나머지를 목표기둥이 아닌 보조기둥으로 보냄
    move_list.append((from_pos, to_pos)) # 2. 맨 아레 가장 큰 기둥을 목적지로 이동
    hanoi(length-1, other_pos, to_pos, from_pos) # 3. 위에서 옮겼던 나머지 기둥들을 목적지에 있는 큰 기둥 위에 얹음

hanoi(n, 1, 3, 2)
# print(move_list)
move_cnt = len(move_list)
print(move_cnt)
for move in move_list:
    print(f'{move[0]} {move[1]}')