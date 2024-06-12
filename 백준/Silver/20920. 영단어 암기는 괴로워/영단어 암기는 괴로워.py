import sys
word_cnt, min_len = map(int, sys.stdin.readline().rstrip().split())

words = list()
word_dict = dict()
for _ in range(word_cnt):
    word = sys.stdin.readline().rstrip()
    
    if len(word) < min_len:
        continue

    word_dict[word] = word_dict.get(word, 0) + 1


sorted_dict = sorted(word_dict.items(), key=lambda item: (-item[1], -len(item[0]), item[0]))

for word, cnt in sorted_dict:
    print(word)