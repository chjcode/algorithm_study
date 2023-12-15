alphabet = 'abcdefghijklmnopqrstuvwxyz'
S = input()

for i in alphabet:
  if i in S:
    print(S.index(i),end=' ')
  else:
    print(-1, end=' ')