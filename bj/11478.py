S = input()
S_set = set()
for i in range(len(S)):
  for j in range(i,len(S)):
    S_set.add(S[i:j+1])

print(len(S_set))
