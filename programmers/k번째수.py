def solution(array, commands):
    answer = []
    for first,end,idx in commands:
        sortedArray = sorted(array[first-1:end])
        answer.append(sortedArray[idx-1])
    
    return answer
