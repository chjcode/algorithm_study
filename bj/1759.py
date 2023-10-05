# 1759 암호 만들기
'''
조건이 까다로운 경우의 수 문제는 백트래킹으로
'''
def dfs(depth):
    if len(password) == l:
        temp1 = 0   # 모음
        temp2 = 0   # 자음
        for p in password:
            if p in ['a','e','i','o','u']:
                temp1 += 1
            else:
                temp2 += 1
            if temp1 > 0 and temp2 > 1:
                print(''.join(password))
                return
        return
    for i in range(depth,c):
        if lst[i] not in password:
            password.append(lst[i])
            dfs(i+1)
            password.pop()
    return

# 입력 받기
l,c = map(int,input().split())
lst = sorted(list(input().split()))
password = []

dfs(0)


