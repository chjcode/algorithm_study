from collections import deque
def solution(n,arr1,arr2):
    
    answer = []

    for i in range(n):
        temp1 = []
        temp2 = []
        while arr1[i]:
            temp1.append(arr1[i]%2)
            arr1[i] = arr1[i] // 2
        
        while len(temp1) < n:
            temp1.append(0)
        
        while arr2[i]:
            temp2.append(arr2[i]%2)
            arr2[i] = arr2[i] //2
        
        while len(temp2) < n:
            temp2.append(0)
        
        answer_i = ''
        for i in range(n-1,-1,-1):
            if temp1[i] == 1 or temp2[i] == 1:
                answer_i += '#'
            else:
                answer_i += ' '
        answer.append(answer_i)
    
    
    return answer
