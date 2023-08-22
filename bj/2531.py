# 2531 회전 초밥

from collections import defaultdict
# import sys
# input = sys.stdin.readline()

n,d,k,c = map(int,input().split())
sushi = [int(input()) for _ in range(n)]
eat = defaultdict(int)
eat[c] += 1 # 쿠폰으로 받은 초밥은 먹은 것으로 초기화

# 초기 k개의 초밥 먹은 것으로 설정 후 시작
for i in range(k):
    eat[sushi[i]] += 1
answer = len(eat)   # 초밥 최소 개수 초기화

for i in range(n):
    # 위에서 0~k번을 골랐다면 1~(k+1)번을 고르기 위해 0번 초밥을 빼줌
    eat[sushi[i]] -= 1
    # 해당 초밥이 0값이 되면 안먹은 것이 되므로 dictionary에서 빼줌
    if eat[sushi[i]] == 0:
        del eat[sushi[i]]   # dictionary의 길이로 초밥 종류 개수를 세므로 제거

    eat[sushi[(i+k)%n]] += 1    # (k+1)번 초밥 추가

    answer = max(answer,len(eat))   # 최대 초밥 개수 갱신

print(answer)