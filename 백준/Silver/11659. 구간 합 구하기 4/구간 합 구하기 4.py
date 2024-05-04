import sys
input = sys.stdin.readline

n, m = map(int,input().split())
lst = list(map(int,input().split()))
prefix_sum = [0]

p = 0
for i in range(n):
    p += lst[i]
    prefix_sum.append(p)

for i in range(m):
    a,b = map(int,input().split())
    print(prefix_sum[b] - prefix_sum[a-1])