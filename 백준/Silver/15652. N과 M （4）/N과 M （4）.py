# 15652 N과 M (4)

def dfs(start):
    if len(lst) == m:
        print(*lst)
        return

    for i in range(start,n+1):
        lst.append(i)
        dfs(i)
        lst.pop()
    return

# 입력 받기
n,m = map(int,input().split())
lst = []

dfs(1)