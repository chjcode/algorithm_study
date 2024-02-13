import itertools
def solution(nums):
    answer = 0
    count = 0
    nums_list = list(itertools.combinations(nums,3))
    
    for i in nums_list:
        num = sum(list(i))
        cnt = 0
        for j in range(1,num+1):
            if num % j == 0:
                cnt += 1
        if cnt == 2:
            count += 1       
    
    return count