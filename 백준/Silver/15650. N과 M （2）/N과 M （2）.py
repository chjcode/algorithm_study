# 15650 N과 M(2)
# 4 2

# 1 2
# 1 3
# 1 4
# 2 3
# 2 4
# 3 4

def dfs(start):
    if len(lst) == m:
        print(*lst)
        return
    
    for i in range(start,n+1):
        if i not in lst:
            lst.append(i)
            dfs(i+1)
            lst.pop()
    return

n,m = map(int,input().split())
lst = []
dfs(1)