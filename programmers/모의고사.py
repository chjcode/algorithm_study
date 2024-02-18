def solution(answers):
    correct = [0,0,0]
    result = []
    correct_1 = 0
    correct_2 = 0
    correct_3 = 0
    len_answer = len(answers)
    num1 = [1,2,3,4,5] 
    num2 = [2,1,2,3,2,4,2,5] 
    num3 = [3,3,1,1,2,2,4,4,5,5]
    
    for idx,answer in enumerate(answers):
        if num1[idx%5] == answer:
            correct[0] += 1
        if num2[idx%8] == answer:
            correct[1] += 1
        if num3[idx%10] == answer:
            correct[2] += 1
    
    for idx,c in enumerate(correct):
        if c == max(correct):
            result.append(idx+1)
    
    return sorted(result)