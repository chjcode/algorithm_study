# def solution(n):
#     answer = ''
#     con124 = ['4','1','2']
    
#     while n:
#         temp = n % 3
#         n = n // 3
        
#         if temp == 0:
#             n -= 1
        
#         answer = con124[temp] + answer
        
           
#     return answer

def solution(n):
    answer = ''
    country124 = ['4','1','2']
    
    while n:
        idx = n % 3
        n = n // 3
        
        if idx == 0:
            n -= 1
        
        answer = country124[idx] + answer

    return answer






















