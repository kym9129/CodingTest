import sys

playable = {
    'Y': 2,
    'F': 3,
    'O': 4
}

inputs = sys.stdin.readlines()

n, game = inputs[0].strip().split()

cnt = 0
limit = 1
played = set()
for inpt in inputs[1:]:
    player = inpt.strip()

    if player in played:
        continue

    played.add(player)
    limit += 1

    if limit == playable[game]:
        cnt += 1
        limit = 1

print(cnt)