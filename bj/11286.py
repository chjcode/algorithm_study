# 11286 절댓값 힙

import sys
import heapq

input = sys.stdin.readline

n = int(input())
lst = []
for _ in range(n):
    x = int(input())
    if x == 0:
        if lst:
            temp = heapq.heappop(lst)
            print(temp[1])
        else:
            print(0)
    else:
        heapq.heappush(lst,(abs(x),x))