from operator import itemgetter

n = int(input())

str_set = set()
for _ in range(n):
    s = input()
    str_set.add(s)

dict_list = list()
for str in str_set:
    dict_list.append({
        'length' : len(str),
        'word' : str
    })

dict_list = sorted(dict_list, key=itemgetter('length', 'word'))
for dict in dict_list:
    print(dict['word'])