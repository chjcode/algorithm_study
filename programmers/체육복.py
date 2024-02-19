def solution(n, lost, reserve):
    answer = 0
    student = [1] * (n+2)
    
    for l in lost:
        student[l] -= 1
    for r in reserve:
        student[r] += 1

    for i in range(1,n+1):
        if student[i] > 1:
            if student[i-1] == 0:
                student[i] -= 1
                student[i-1] += 1
            elif student[i+1] == 0:
                student[i] -= 1
                student[i+1] += 1
    
    for i in range(1,n+1):
        if student[i] > 0:
            answer += 1
    return answer