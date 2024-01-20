def solution(arr):
    answer = []
    stack = -1
    for num in arr:
        if num == stack:
            continue
        answer.append(num)
        stack = num
    return answer
