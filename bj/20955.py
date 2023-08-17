# 20955 민서의 응급 수술

# import sys

# input = sys.stdin.readline

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a,b):
    ra = find(a)
    rb = find(b)
    parent[ra] = parent[rb] = min(ra,rb)

# 1. 입력
n,m = map(int,input().split())
parent = [i for i in range(n+1)]
cnt = 0

for _ in range(m):
    u,v = map(int,input().split())

    if find(u) == find(v):  # 부모가 같으면 싸이클
        cnt += 1
    else:   # 싸이클이 없으면 union
        union(u,v)

# 떨어진 노드 최상위 노드에 연결
for i in range(1,n+1):
    if find(i-1) != find(i):
        union(i-1,i)
        cnt += 1

print(cnt-1)
