n = int(input())
student_list = list(map(int, input().split()))
b, c = map(int, input().split())

sum = 0
for student in student_list:
    student = student - b
    sum += 1
    if student <= 0:
        continue
    elif student <= c:
        sum += 1
    else:
        sum += student // c
        if student % c > 0:
            sum += 1

print(sum)