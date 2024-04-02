# 1629 곱셈

def dac (a,b):
  if b == 1:
      return a%c
  else:
      tmp = dac(a,b//2)

      if b % 2 ==0:
          return (tmp * tmp) % c
      else:
          return (tmp  * tmp * a) % c


a,b,c = map(int,input().split())
print(dac(a,b))