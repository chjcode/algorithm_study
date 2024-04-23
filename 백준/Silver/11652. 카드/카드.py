# 11652 카드
import sys
input = sys.stdin.readline

n = int(input())
dic = {}
for i in range(n):
    card = int(input())
    if card in dic.keys():
        dic[card] += 1
    else:
        dic[card] = 1

sorted_cards = sorted(dic.items(),key = lambda x:(-x[1],x[0]))
print(sorted_cards[0][0])
