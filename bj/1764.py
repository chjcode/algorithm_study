N,M = input().split()
N_set = set()
M_set = set()
for i in range(int(N)):
  N_set.add(input())

for i in range(int(M)):
  M_set.add(input())

N_set = sorted(list(N_set&M_set)) ###

print(len(N_set))
print(*N_set, sep='\n')
