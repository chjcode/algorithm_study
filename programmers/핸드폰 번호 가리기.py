def solution(phone_number):
    
    numLen = len(phone_number)
    
    answer = '*'*(numLen-4) + phone_number[-4:]
    
    return answer