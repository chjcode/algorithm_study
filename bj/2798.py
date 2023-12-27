from itertools import permutations
from itertools import combinations

N,M = map(int,input().split())
card = list(map(int,input().split()))
temp = 0

card_com = list(map(sum,combinations(card,3)))
for i in card_com:
  if i <= M and i > temp:
    temp = i

print(temp)