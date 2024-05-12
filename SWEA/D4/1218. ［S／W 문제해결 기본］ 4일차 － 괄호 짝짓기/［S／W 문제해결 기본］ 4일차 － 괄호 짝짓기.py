t = 10
for tc in range(1,t+1):
    n = int(input())
    lst = list(input())
    answer = 1
    stack = []
    for l in lst:
        if l in ['(','{','[','<']:
            stack.append(l)
        elif l == ')' and stack[-1] == '(':
            stack.pop()
        elif l == '}' and stack[-1] == '{':
            stack.pop()
        elif l == ']' and stack[-1] == '[':
            stack.pop()
        elif l == '>' and stack[-1] == '<':
            stack.pop()
        else:
            answer = 0
            break
    
    print(f'#{tc} {answer}')