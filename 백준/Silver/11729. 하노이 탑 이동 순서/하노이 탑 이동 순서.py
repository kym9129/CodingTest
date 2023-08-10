n = int(input())

move_list = list()

def hanoi(length, from_pos, to_pos, other_pos):
    if length == 0:
        return
    hanoi(length-1, from_pos, other_pos, to_pos)
    move_list.append((from_pos, to_pos))
    hanoi(length-1, other_pos, to_pos, from_pos)

hanoi(n, 1, 3, 2)

print(len(move_list))
for move in move_list:
    print(f'{move[0]} {move[1]}')