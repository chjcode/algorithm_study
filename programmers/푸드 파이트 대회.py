def solution(food):
    answer = ''
    answer1 = []
    answer2 = []
    cnt = 0
    for i in range(1,len(food)):     
        temp = food[i]//2
        for j in range(temp):
            answer1.append(str(i))
            cnt += 1
    
    answer2 = answer1[::-1]
    answer = ''.join(answer1) + '0' + ''.join(answer2)
    
    return answer