N,M = map(int,input().split())
S = set([input() for i in range(N)])
cnt = 0

for i in range(M):
  temp = input()
  if temp in S:
    cnt += 1

print(cnt)