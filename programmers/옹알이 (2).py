# 다시 풀어볼 것
def solution(babbling):
    answer = 0

    b_lst = ['aya','ye','woo','ma']

    for i in babbling:
        for j in b_lst:
            if j*2 not in i:
                i = i.replace(j,' ')
        
        if i.strip() == '':
            answer += 1
              

    return answer