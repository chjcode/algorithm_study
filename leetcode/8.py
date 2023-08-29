class Solution:
    def myAtoi(self, s: str) -> int:
        s = s.lstrip()

        if len(s) == 0:
            return 0

        sign = 1
        
        if s[0] == '-' or s[0] == '+':
            if s[0] == '-':
                sign = -1
            s = s[1:]

        word = ''
        for c in s:
            if c.isdigit():
                word += c
            else:
                break
        
        if word:
            num = int(word) * sign
            if num < -2**31:
                num = -2**31
            elif num > 2**31-1:
                num = 2**31-1
            return num
        else:
            return 0