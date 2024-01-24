def solution(s):
    def checkLength(s):
        s_len = len(s)
        if s_len == 4 or s_len == 6:
            return True
        return False

    def checkNum(s):
        nums = "0123456789"
        for el in s:
            if el not in nums:
                return False
        return True
    
    answer = False
    if checkLength(s):
        answer = checkNum(s)
    
    return answer