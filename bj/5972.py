# 5972 택배 배송 -> 다익스트라

import heapq

def dijkstra():
    q = []
    heapq.heappush(q, [0,1])
    total = [int(1e9) for _ in range(n+1)]
    total[1] = 0

    while q:
        cost, node = heapq.heappop(q)
        if node == n:
            return total[node]
        if total[node] < cost:
            continue
        for g_node, g_cost in graph[node]:
            if cost+g_cost < total[g_node]:
                total[g_node] = cost+g_cost
                heapq.heappush(q, [cost+g_cost, g_node])


# 입력 받기
n,m = map(int,input().split())
graph = [[] for _ in range(n+1)]
for _ in range(m):  # 입력을 그래프로
    a,b,c = map(int,input().split())
    graph[a].append([b,c])
    graph[b].append([a,c])

print(dijkstra())