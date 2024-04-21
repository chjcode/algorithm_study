# 9663 N-Queen 

n = int(input())
a = [False for _ in range(n)]
b = [False for _ in range(2*n-1)]
c = [False for _ in range(2*n-1)]
answer = 0

def dfs(depth):
    global answer
    if depth == n:
        answer += 1
        return
    for i in range(n):
        if not (a[i] or b[depth+i] or c[n-depth+i-1]):
            a[i] = b[depth+i] = c[n-depth+i-1] = True
            dfs(depth+1)
            a[i] = b[depth+i] = c[n-depth+i-1] = False
    return

dfs(0)
print(answer)
            