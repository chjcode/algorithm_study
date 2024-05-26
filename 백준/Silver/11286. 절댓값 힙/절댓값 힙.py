import sys
input = sys.stdin.readline

import heapq

n = int(input())
lst = []
for _ in range(n):
    num = int(input())
    if num != 0:
        heapq.heappush(lst,(abs(num),num))
    else:
        if lst:
            print(heapq.heappop(lst)[1])
        else:
            print(0)
