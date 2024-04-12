# 15654 N과 M (5)

# 2. 백트래킹 함수
def dfs(depth):
    if depth == m:
        print(*lst)
        return
    
    for i in range(n):
        if n_lst[i] in lst:
            continue
        lst.append(n_lst[i])
        dfs(depth+1)
        lst.pop()
    return

# 1. 입력 받기
n,m = map(int,input().split())
n_lst = sorted(list(map(int,input().split())))
lst = []
# 3. 백트래킹으로 순회
dfs(0)