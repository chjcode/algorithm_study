visited = set()
dic = {}
count = 0

for i in range(int(input())):
  dic[i+1] = set()  #컴퓨터 수만큼 dictionary를 만듦
for j in range(int(input())): #연결된 횟수만큼 서로 연결시켜줄것임
  a,b = map(int,input().split())
  dic[a].add(b) #dictionary에 서로 추가시켜줌으로써 연결
  dic[b].add(a)

def dfs(start,dic):
  visited.add(start)
  for i in dic[start]:
    if i not in visited:
      global count
      count += 1
      dfs(i,dic)

dfs(1,dic)
print(count)