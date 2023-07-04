import sys

# 참고 : https://great-park.tistory.com/48

n = int(sys.stdin.readline())
consulting_list = [(0, 0)] * (n+1)
dp = [0] * (n+2)

for i in range(1, n+1):
    time, price = map(int, sys.stdin.readline().split())
    consulting_list[i] = (time, price)

leave_day = n+1

for i in range(n, -1, -1): # n~0까지 역순
    time, price = consulting_list[i]

    if i + time > leave_day:
        dp[i] = dp[i+1] # 여기 때문에 dp 선언 시 n+2개로 선언
    
    else:
        # i일에 상담하는 것과 상담 안하는 것 중 큰 것을 선택
        dp[i] = max(dp[i+time] + price , dp[i+1])

print(dp[0])
