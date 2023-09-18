# 1283 단축키 지정

# 입력받기
n = int(input())
lst = [input() for _ in range(n)]

shortcut = []


for s in lst:
    flag = True
    # 첫 번째 조건
    if not s[0].upper() in shortcut:
        shortcut.append(s[0].upper())
        s = '['+s[0]+']'+s[1:]
        # s = s.replace(s[0],'['+s[0]+']',1)
        print(s)
        flag = False
    # 첫 번째 조건
    elif ' ' in s:
        idx = s.index(' ') + 1
        if not s[idx].upper() in shortcut:
            shortcut.append(s[idx].upper())
            s = s[:idx] + '['+s[idx]+']'+ s[idx+1:]
            # s = s.replace(s[idx],'['+s[idx]+']',1)
            print(s)
            flag = False
    # 두 번째 조건
    if flag:
        for i in range(1,len(s)):
            if s[i] == ' ':
                continue
            if not s[i].upper() in shortcut:
                shortcut.append(s[i].upper())
                s = s[:i] + '['+s[i]+']'+ s[i+1:]
                s = s.replace(s[i],'['+s[i]+']',1)
                print(s)
                break
        else:
            print(s)