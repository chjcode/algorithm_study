# 15686 치킨 배달

# 0은 빈 칸, 1은 집, 2는 치킨집
n,m = map(int,input().split())  # n : graph 크기, m : 수익을 많이 낼 수 있는 치킨집 개수
graph = [list(map(int,input().split())) for _ in range(n)]
house = []
chicken = []

for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            house.append((i,j))
        elif graph[i][j] == 2:
            chicken.append((i,j))

from itertools import combinations
answer = 2e9
for combi in combinations(chicken,m):
    cnt = 0

    for x,y in house:
        temp = 2e9
        for a,b in combi:
            temp = min(abs(x-a) + abs(y-b),temp)
        cnt += temp

    answer = min(answer,cnt)

print(answer)