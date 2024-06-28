def cal_bonus(point, bonus):
    if bonus == 'S':
        return point
    elif bonus == 'D':
        return point * point
    elif bonus == 'T':
        return point * point * point


def solution(dartResult):

    cal_list = list()
    is_skip = False
    for i in range(len(dartResult)):
        if is_skip == True:
            is_skip = False
            continue

        if dartResult[i].isdigit():
            if dartResult[i+1].isdigit():
                point = int(dartResult[i] + dartResult[i+1])
                cal_list.append(point)
                is_skip = True
                continue

            cal_list.append(int(dartResult[i]))
            continue

        elif dartResult[i] in ['S', 'D', 'T']:
            prev_point = cal_list.pop()
            point = cal_bonus(prev_point, dartResult[i])
            cal_list.append(point)
            continue

        elif dartResult[i] == '*':
            # 자기점수. 자기 직전 점수 2배
            if len(cal_list) == 1:
                prev_point = cal_list.pop()
                cal_list.append(prev_point * 2)
                continue

            # 자기 + 자기 직전
            if len(cal_list) >= 2:
                prev_point = cal_list.pop()
                prev_prev_point = cal_list.pop()
                cal_list.append(prev_prev_point * 2)
                cal_list.append(prev_point * 2)
                continue

        elif dartResult[i] == '#':
            prev_point = cal_list.pop()
            new_point = prev_point * -1
            cal_list.append(new_point)
            continue

    return sum(cal_list)