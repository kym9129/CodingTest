# https://claude-u.tistory.com/122

n = int(input())
people = list()
for _ in range(n):
     w, h = map(int, input().split())
     people.append((w, h))
     
for a in people:
    rank = 1
    for b in people:
        if a[0] < b[0] and a[1] < b[1]:
            rank += 1
    print(rank, end=' ')