def solution(nums):
    po = list(set(nums))
    
    return min(len(po),len(nums)//2)