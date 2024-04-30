# 14888 연산자 끼워넣기


def dfs(depth,result):
    global max_num, min_num
    
    if depth == n-1:
        max_num = max(max_num,result)
        min_num = min(min_num,result)
        return
    
    if symbol[0] > 0:               # plus
        symbol[0] -= 1
        dfs(depth+1,result+lst[depth+1])
        symbol[0] += 1
    if symbol[1] > 0:               # minus
        symbol[1] -= 1
        dfs(depth+1,result-lst[depth+1])
        symbol[1] += 1
    if symbol[2] > 0:
        symbol[2] -= 1
        dfs(depth+1,result*lst[depth+1])    # multiplication
        symbol[2] += 1
    if symbol[3] > 0:
        symbol[3] -= 1
        if result < 0:
            dfs(depth+1,-(-result//lst[depth+1]))
        else:
            dfs(depth+1,result//lst[depth+1])   # division
        symbol[3] += 1

n = int(input())
lst = list(map(int,input().split()))
symbol = list(map(int,input().split()))
max_num = -2e9
min_num = 2e9

dfs(0,lst[0])

print(max_num)
print(min_num)