#2447 별 찍기-10

N = int(input())

def star(i,j,n):   
  if (i//n)%3 ==1 and (j//n)%3 == 1:
    print(' ',end='')
  else:
    if n//3 == 0:
      print('*',end='')
    else:
      star(i,j,n//3)

for i in range(N):
  for j in range(N):
    star(i,j,N)
  print('')