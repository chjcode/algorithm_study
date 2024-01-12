num = int(input())

for _ in range(num):
  top = []
  vps = input()
  for i in vps:
    if i == '(':
      top.append(i)
    elif i == ')' and len(top) != 0:
      top.pop(-1)
    else:
      top.append(i)
      break
  if len(top) == 0:
    print('YES')
  else:
    print('NO')