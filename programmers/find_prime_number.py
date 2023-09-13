from itertools import permutations

def solution(numbers):
    
    answer = 0
    num_lst = []
    
    for i in range(1,len(numbers)+1):   # 경우의 수
        for p in permutations(numbers,i):
            num_lst.append(int(''.join(p)))
    
    num_lst = set(num_lst)  # 중복 제거
    
    # 소수 판별, 에라토스테네스의 체 활용
    max_num = max(num_lst)
    temp = [False,False] + [True for _ in range(max_num-1)]
    
    for i in range(2,(int((max_num+1)**0.5))):
        for j in range(i*2,max_num+1,i):
            temp[j] = False
    
    for i in num_lst:
        if temp[i]:
            answer += 1
    
    return answer