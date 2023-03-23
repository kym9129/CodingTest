n, d = map(int, input().split())

cnt = 0
for i in range(1, n+1):
    temp_str = str(i)
    for j in range(len(temp_str)):
        if temp_str[j] == str(d):
            cnt += 1

print(cnt)