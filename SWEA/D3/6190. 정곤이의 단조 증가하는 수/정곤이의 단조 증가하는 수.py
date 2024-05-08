from itertools import combinations

def check(num):
    s_num = str(num)
    len_s_num = len(s_num)

    if len_s_num == 1:
        return True
    else:
        before = s_num[0]
        for i in range(1,len_s_num):
            if before > s_num[i]:
                return False
            else:
                before = s_num[i]
        
        return True
        


t = int(input())

for tc in range(1,t+1):
    n = int(input())
    lst = list(map(int,input().split()))
    answer = 0
    
    if n == 1:
        answer = 1
    else:
        flag = True
        for i,j in combinations(lst,2):
            multiply = i * j
            if check(multiply):
                flag = False
                answer = max(answer,multiply)
    if flag:    # 단조 증가하는 수가 없으면
        answer = -1
    print(f'#{tc} {answer}')