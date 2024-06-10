import sys


rank_cnt, point, rank_cnt_limit = map(int, input().split())

if rank_cnt == 0:
    print(1)
    sys.exit()

ranks = list(map(int, input().split()))

# 등수 구하기 (최대 50번 순회)

len = min(rank_cnt, rank_cnt_limit)
flag = False
for i in range(len):
    # 랭크인 못할 경우
    if rank_cnt == rank_cnt_limit and ranks[len-1] >= point:
        print(-1)
        sys.exit()
    
    # 1등
    if ranks[0] <= point:
        print(1)
        sys.exit()

    if point >= ranks[i]:
        print(i+1)
        flag = True
        sys.exit()

if flag == False:
    print(len+1)

