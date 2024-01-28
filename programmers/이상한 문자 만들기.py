def solution(s):
    answer = []
    lst = s.split(' ')
    for word in lst:
        temp = ''
        for i in range(len(word)):
            if i % 2 == 1:
                temp += (word[i].lower())
            else:
                temp += (word[i].upper())
        answer.append(temp)
    
    
    return ' '.join(answer)