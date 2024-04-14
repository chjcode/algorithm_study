# 15656 N과 M(7)

# 4 2
# 9 8 7 1

# 1 1
# 1 7
# 1 8
# 1 9
# 7 1
# 7 7
# 7 8
# 7 9
# 8 1
# 8 7
# 8 8
# 8 9
# 9 1
# 9 7
# 9 8
# 9 9

def dfs(depth):
    if depth == m:
        print(*temp)
        return
    
    for i in range(n):
        temp.append(lst[i])
        dfs(depth+1)
        temp.pop()
    return

n,m = map(int,input().split())
lst = sorted(list(map(int,input().split())))
temp = []

dfs(0)
