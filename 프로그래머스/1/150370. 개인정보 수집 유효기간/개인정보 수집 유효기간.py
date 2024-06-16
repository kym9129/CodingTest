from datetime import datetime

def create_term_table(terms):
    term_table = dict()
    for term in terms:
        name, months = term.split()
        term_table[name] = int(months)
    return term_table

def plus_month(target_date, month):
    new_month = int(target_date.month) + month
    new_year = int(target_date.year)
    if new_month > 12:
        new_year = new_year + (new_month - 1) // 12
        new_month = (new_month - 1) % 12 + 1
    
    return target_date.replace(year=new_year, month=new_month, day=target_date.day)


def have_to_delete(today, terms, privacy):
    
    term_table = create_term_table(terms)
    start_date, term_type = privacy.split()
    today = datetime.strptime(today, '%Y.%m.%d')
    start_date = datetime.strptime(start_date, '%Y.%m.%d')

    end_date = plus_month(start_date, term_table[term_type])
    print(end_date)

    return end_date <= today



def solution(today, terms, privacies):
    answer = []

    for i, privacy in enumerate(privacies):

        if have_to_delete(today, terms, privacy):
            answer.append(i+1)

    return answer