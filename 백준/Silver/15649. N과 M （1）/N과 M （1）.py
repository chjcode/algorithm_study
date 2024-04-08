from itertools import permutations

n,m = map(int,input().split())
lst = [i for i in range(1,n+1)]
lst_per = list(permutations(lst,m))

for i in lst_per:
  print(*i)