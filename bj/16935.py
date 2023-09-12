# 16935 배열 돌리기 3

# 입력 받기
n,m,r = map(int,input().split())
graph = [list(map(int,input().split())) for i in range(n)]
operations = map(int,input().split())

# 상하반전
def one():
    temp = [[0 for j in range(m)] for i in range(n)]
    for i in range(n):
        temp[i] = graph[(n-1)-i]
    return temp

# 좌우반전
def two():
    temp = [[0 for j in range(m)] for i in range(n)]
    for i in range(n):
        for j in range(m):
            temp[i][j] = graph[i][(m-1)-j]
    return temp

# 오른쪽 회전
def three():
    temp = [[0 for j in range(n)] for i in range(m)]
    for i in range(m):
        for j in range(n):
            temp[i][j] = graph[(n-1)-j][i]
    return temp

# 왼쪽 회전
def four():
    temp = [[0 for j in range(n)] for i in range(m)]
    for i in range(m):
        for j in range(n):
            temp[i][j] = graph[j][m-1-i]
    return temp


def five():
    temp = [[0 for j in range(m)] for i in range(n)]
    for i in range(0,n//2):
        for j in range(0,m//2):
            temp[i][j] = graph[n//2+i][j]
        for j in range(m//2,m):
            temp[i][j] = graph[i][j-m//2]
    for i in range(n//2,n):
        for j in range(0,m//2):
            temp[i][j] = graph[i][j+m//2]
        for j in range(m//2,m):
            temp[i][j] = graph[i-n//2][j]
    return temp

def six():
    temp = [[0 for j in range(m)] for i in range(n)]
    for i in range(0,n//2):
        for j in range(0,m//2):
            temp[i][j] = graph[i][j+m//2]
        for j in range(m//2,m):
            temp[i][j] = graph[n//2+i][j]
    for i in range(n//2,n):
        for j in range(0,m//2):
            temp[i][j] = graph[i-n//2][j]
        for j in range(m//2,m):
            temp[i][j] = graph[i][j-m//2]
    return temp


for operation in operations:
    if operation == 1:
        graph = one()
    elif operation == 2:
        graph = two()
    elif operation == 3:
        graph = three()
        n,m = m,n
    elif operation == 4:
        graph = four()
        n,m = m,n
    elif operation == 5:
        graph = five()
    elif operation == 6:
        graph = six()

for i in range(n):
    print(*graph[i])