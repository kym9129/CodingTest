n = int(input())
consulting_list = [None] * (n+1)
for i in range(1, n+1):
    time, price = map(int, input().split())
    consulting_list[i] = (time, price)

# 최대 수익 구하기

dp = [0] * (n+1)
for i in range(n, 0, -1):
    time, price = consulting_list[i]
    if i == n:
        if time == 1:
            dp[i] += price
    else:
        if i+time-1 <= n:
            dp[i] += price
        if i+time <= n:
            dp[i] += max(dp[i+time : n+1])

print(max(dp))