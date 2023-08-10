import sys
# sys.stdin = open("./python/backjoon/backjoonInput.txt", "rt") # vscode

# n = int(input())
n = int(sys.stdin.readline())
consulting_list = list()
for _ in range(n):
    # time, price = map(int, input().split())
    time, price = map(int, sys.stdin.readline().split())
    consulting_list.append((time, price))

LEAVE_DAY = n+1
dp = [0] * (n+1)

for i in range(n-1, -1, -1):
    time, price = consulting_list[i]
    if i + time >= LEAVE_DAY:
        dp[i] = dp[i+1]
    else:
        dp[i] = max(dp[i+time]+price, dp[i+1])
    
# print(dp)
print(dp[0])