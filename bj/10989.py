import sys
input = sys.stdin.readline

lst = [0]*10000
N = int(input())

for i in range(N):
  temp = int(input())
  lst[temp-1] += 1

for i in range(10000):
  if lst[i] != 0:
    for j in range(lst[i]):
      print(i+1)