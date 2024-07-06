def solution(n, arr1, arr2):
    # or 비트연산


    answer = []
    for i in range(n):
        
        new_bin = bin(arr1[i] | arr2[i])[2:].zfill(n)
        s = ''
        for b in new_bin:
            if b == '0':
                s += ' '
            else:
                s += '#'
            
        answer.append(s)


    return answer