N,M = map(int,input().split())
per = []

def dfs(x):
  if len(per) == M and x <= N:
    print(*per)
    return

  for i in range(1,N+1):
    per.append(i)
    dfs(i)
    per.pop()


dfs(1)