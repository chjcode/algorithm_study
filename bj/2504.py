# 2504 괄호의 값


lst = input()

if lst[0] in [')',']']:
    print(0)
else:
    stack = []
    cnt = 1
    answer = 0
    for i in range(len(lst)):
        if lst[i] == '(':
            stack.append(lst[i])
            cnt *= 2
        elif lst[i] == '[':
            stack.append(lst[i])
            cnt *= 3
        elif lst[i] == ')':
            if stack:
                if stack[-1] == '(' and lst[i-1] == '(':
                    stack.pop()
                    answer += cnt
                    cnt //= 2
                elif stack[-1] == '(' and lst[i-1] != '(':
                    stack.pop()
                    cnt //= 2
                else:
                    print(0)
                    break
            else:
                print(0)
                break
        elif lst[i] == ']':
            if stack:
                if stack[-1] == '[' and lst[i-1] == '[':
                    stack.pop()
                    answer += cnt
                    cnt //= 3
                elif stack[-1] == '[' and lst[i-1] != '[':
                    stack.pop()
                    cnt //=3
                else:
                    print(0)
                    break
            else:
                print(0)
                break
    else:
        if stack:
            print(0)
        else:
            print(answer)

