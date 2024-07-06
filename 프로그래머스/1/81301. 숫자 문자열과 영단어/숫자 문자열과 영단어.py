def solution(s):
    alphabets = ['zero', 'one', 'two','three','four','five','six','seven','eight','nine']

    answer = ''
    search_word = ''
    for word in s:
        if word.isdigit():
            answer += word
            continue
        
        search_word += word
        if not search_word in alphabets:
            continue

        answer += str(alphabets.index(search_word))
        search_word = ''



    return int(answer)