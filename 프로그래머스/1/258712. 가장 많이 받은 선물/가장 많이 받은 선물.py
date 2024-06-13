def solution(friends, gifts):
     # 주고받은 테이블
    gift_table = [[0 for _ in range(len(friends))] for _ in range(len(friends))]
    # 지수
    idxs = [0 for _ in range(len(friends))]
    for gift_log in gifts:
        sender, reciever = gift_log.split()

        x = friends.index(sender)
        y = friends.index(reciever)

        gift_table[x][y] += 1
        idxs[x] += 1
        idxs[y] -= 1

    # 비교
    rank = [0 for _ in range(len(friends))]
    for a in range(len(friends)):
        for b in range(len(friends)):
            if a == b:
                continue

            if (gift_table[a][b] == 0 and gift_table[b][a] == 0) or gift_table[a][b] == gift_table[b][a]:
                # 지수 비교
                if idxs[a] > idxs[b]:
                    rank[a] += 1
            
            elif gift_table[a][b] > gift_table[b][a]:
                rank[a] += 1

    return max(rank)