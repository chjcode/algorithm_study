N = int(input())
result = 0

for i in range(1,N+1):
  temp = list(str(i))
  temp = list(map(int,temp))
  if sum(temp) + i == N:
    result = i
    break

print(result)