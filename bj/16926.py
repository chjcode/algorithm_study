# 16926 배열 돌리기 1

def Rotate():
    for i in range(min(n,m)//2):    # 외부,내부 회전시켜야 하는 총 개수
        x,y = i,i
        prev = graph[x][y]

        for j in range(i+1,n-i):    # 왼쪽
            x = j
            now = graph[x][y]
            graph[x][y] = prev
            prev= now
        
        for j in range(i+1,m-i):    # 아래쪽
            y = j
            now = graph[x][y]
            graph[x][y] = prev
            prev = now
        
        for j in range(i+1,n-i):    # 오른쪽
            x = n-j-1
            now = graph[x][y]
            graph[x][y] = prev
            prev = now
        
        for j in range(i+1,m-i):    # 위쪽
            y = m-j-1
            now = graph[x][y]
            graph[x][y] = prev
            prev = now



n,m,r = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]

for _ in range(r):
    Rotate()

for i in range(n):
    print(*graph[i])
