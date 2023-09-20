# 1915 가장 큰 정사각형

# 입력받기
n,m = map(int,input().split())
graph = [list(map(int,list(input()))) for _ in range(n)]

area = 0
for i in range(n):
    for j in range(m):
        if i > 0 and j > 0 and graph[i][j] == 1:
            graph[i][j] = min(graph[i-1][j-1], graph[i-1][j], graph[i][j-1]) + 1

        area = max(graph[i][j],area)

print(area**2)