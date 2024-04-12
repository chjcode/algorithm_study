# 15654 N과 M(5)
# 4 2
# 9 8 7 1

# 1 7
# 1 8
# 1 9
# 7 1
# 7 8
# 7 9
# 8 1
# 8 7
# 8 9
# 9 1
# 9 7
# 9 8
from itertools import permutations

n,m = map(int,input().split())
lst = sorted(list(map(int,input().split())))

answer = list(permutations(lst,m))
for a in answer:
    print(*a)

# def dfs(depth):
#     if depth == m:
#         print(*answer)
#         return
    
#     for i in range(n):
#         if lst[i] not in answer:
#             answer.append(lst[i])
#             dfs(depth+1)
#             answer.pop()
#     return

# n,m = map(int,input().split())
# lst = sorted(list(map(int,input().split())))
# answer = []

# dfs(0)