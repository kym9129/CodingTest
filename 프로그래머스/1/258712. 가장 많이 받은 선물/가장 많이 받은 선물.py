def solution(friends, gifts):
    # 주고받은 테이블
    gift_table = [[0 for _ in range(len(friends))] for _ in range(len(friends))]
    for gift_log in gifts:
        sender, reciever = gift_log.split()

        gift_table[friends.index(sender)][friends.index(reciever)] += 1
    
    # print(gift_table)

    # 지수
    idxs = [0 for _ in range(len(friends))]
    for i in range(len(friends)):

        send_sum = 0
        recieve_sum = 0
        for j in range(len(friends)):
            send_sum += gift_table[i][j]
            recieve_sum += gift_table[j][i]
        
        idxs[i] = send_sum - recieve_sum


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
                elif idxs[b] > idxs[a]:
                    rank[b] += 1
            
            elif gift_table[a][b] > gift_table[b][a]:
                rank[a] += 1
            elif gift_table[b][a] > gift_table[a][b]:
                rank[b] += 1

    rank2 = list()
    for x in rank:
        if x == 0:
            rank2.append(x)
            continue

        rank2.append(x // 2)

    rank2.sort(reverse=True)

    return rank2[0]