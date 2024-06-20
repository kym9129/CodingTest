from collections import defaultdict

def solution(survey, choices):

    point = defaultdict(int)
    for i, s in enumerate(survey):
        left = s[0]
        right = s[1]
        
        # for choice in choices:
        choice = choices[i]
        if choice > 4:
            point[right] = point[right] + (choice - 4)
        elif choice < 4:
            point[left] = point[left] + (4 - choice)
    
    
    print(point)

    answer = ''
    for s in ['RT', 'CF', 'JM', 'AN']:
        left = s[0]
        right = s[1]

        if point[left] == point[right]:
            answer += min(left, right)
        
        elif point[left] > point[right]:
            answer += left
        elif point[left] < point[right]:
            answer += right

    
    return answer