def solution(a,b):
    lst = ["SUN","MON","TUE","WED","THU","FRI","SAT"]

    month = [31,29,31,30,31,30,31,31,30,31,30,31]
    
    count = 0
    for i in range(a-1):
        count += month[i]
        
    temp = (count + b + 4) % 7
    answer = lst[temp]
    return answer