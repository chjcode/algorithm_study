import sys
input = sys.stdin.readline

n = int(input())
lst = sorted([int(input()) for _ in range(n)])
answer = 0

for i in range(n):
    answer = max(lst[i]*(n-i),answer)


print(answer)
