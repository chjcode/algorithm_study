# 6603 로또
def dfs(depth,idx):
  global s,k,lst
  if depth == 6:  #종료조건
    print(*lst)
    return
  
  for i in range(idx,k):
    lst.append(s[i])
    dfs(depth+1,i+1)
    lst.pop()

#main
while True:
  temp = list(map(int,input().split()))
  k = temp[0]
  if k == 0:
    break
  s = temp[1:]
  lst = []
  dfs(0,0)
  print('')