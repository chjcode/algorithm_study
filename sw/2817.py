# 입력
# 1
# 4 3
# 1 2 1 2

# 출력
# #1 4

# swea 2817. 부분 수열의 합
from itertools import combinations

t = int(input())

for tc in range(1,t+1):
    n,k = map(int,input().split())
    lst = list(map(int,input().split()))

    cnt = 0
    for i in range(1,n+1):
        for j in combinations(lst,i):
            if sum(j) == k:
                cnt += 1

    print(f'#{tc} {cnt}')