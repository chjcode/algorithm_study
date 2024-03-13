def solution(ingredient):
    answer = 0
    hamburger = [1,2,3,1]
    stack = []
    for i in ingredient:
        stack.append(i)
        if stack[-4:] == hamburger:
            answer += 1
            for j in range(4):
                stack.pop()
            
    return answer