# 15655 N과 M(6)

# 4 2
# 9 8 7 1

# 1 7
# 1 8
# 1 9
# 7 8
# 7 9
# 8 9

def dfs(start):
    if len(temp) == m:
        print(*temp)
        return
    
    for i in range(start,n):
        if lst[i] not in temp:
            temp.append(lst[i])
            dfs(i+1)
            temp.pop()
    return


n,m = map(int,input().split())
lst = sorted(list(map(int,input().split())))
temp = []
dfs(0)