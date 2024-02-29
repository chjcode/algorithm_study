def solution(s):
    answer = s
    
    numbers = {'zero':'0','one':'1', 'two':'2', 'three':'3','four':'4','five':'5', 'six':'6','seven':'7','eight':'8', 'nine':'9'}
    
    for num in numbers.keys():
        if num in answer:
            answer = answer.replace(num,numbers[num])
    answer = int(answer)
    return answer