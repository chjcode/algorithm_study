def solution(n):
    answer = 0
    n3_list = []
    while n >= 3:
        n3_list.append(n%3)
        n = n // 3
    n3_list.append(n)

    n3_len = len(n3_list)
    for i in n3_list:
        answer += i * (3 ** (n3_len-1))
        n3_len -= 1
    
    return answer