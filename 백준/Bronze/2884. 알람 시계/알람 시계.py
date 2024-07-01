a,b = map(int,input().split())
b = b-45
if b<0:
  a-=1
a = (a+24)%24
b = (b+60)%60 
print('{} {}'.format(a,b))