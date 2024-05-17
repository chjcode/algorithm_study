
n = int(input())
g = [list(map(int,input().split())) for _ in range(n)]

for k in range(n):
    for i in range(n):
        for j in range(n):
            if g[i][k] == 1 and g[k][j] == 1:
                g[i][j] = 1

for i in range(n):
    print(*g[i])