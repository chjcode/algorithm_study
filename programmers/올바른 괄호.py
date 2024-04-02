# def solution(s):
#     answer = True
#     top = []
    
#     for i in s:
#         if i == '(':
#             top.append(i)
#         elif i == ')':
#             if '(' in top:
#                 top.pop()
#             else:
#                 answer = False
#                 break
#     if top:
#         answer = False

#     return answer

def solution(s):
    stack = []
    
    for el in s:
        if el == '(':
            stack.append(el)
        else:
            if not stack:
                stack.append(el)
                break
            stack.pop()
    
    if stack:
        return False
    else:
        return True

