T = int(input())

for i in range(T):
  R,S = input().split()
  for i in S:
    for _ in range(int(R)):
      print(i,end='')
  print('')