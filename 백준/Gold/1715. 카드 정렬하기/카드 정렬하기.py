import sys
input = sys.stdin.readline

import heapq

n = int(input())
lst = []

for _ in range(n):
    heapq.heappush(lst,int(input()))

answer = 0
while True:
    if len(lst) < 2:
        break
    temp = heapq.heappop(lst) + heapq.heappop(lst)
    heapq.heappush(lst,temp)
    answer += temp

print(answer)