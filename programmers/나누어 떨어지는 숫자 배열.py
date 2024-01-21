def solution(arr, divisor):
    answer = []
    for element in arr:
        if element % divisor == 0:
            answer.append(element)        
    
    if not answer:
        answer.append(-1)
    
    answer = sorted(answer)
    
    return answer