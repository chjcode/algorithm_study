#numbers: 정수 배열
#answer : numbers로 만들 수 있는 모든 경우의 수

def solution(numbers):
    answer = []
    num_len = len(numbers)
    
    for i in range(num_len):
        for j in range(i+1,num_len):
            temp = numbers[i] + numbers[j]
            if not temp in answer:
                answer.append(temp)
    answer = sorted(answer)
            
            
    return answer