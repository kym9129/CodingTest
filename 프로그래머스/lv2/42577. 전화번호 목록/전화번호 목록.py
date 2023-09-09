def solution(phone_book):
    phone_book = sorted(phone_book)
    
    for i in range(len(phone_book)-1):
        p1 = phone_book[i]
        p2 = phone_book[i+1]
        
        if p2.startswith(p1):
            return False
    
    return True