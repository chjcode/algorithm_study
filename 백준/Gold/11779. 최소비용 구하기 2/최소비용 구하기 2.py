import sys
import heapq

input = sys.stdin.readline
INF = sys.maxsize

# 입력 받기
num_cities = int(input())
num_buses = int(input())
graph = [[] for _ in range(num_cities + 1)]

for _ in range(num_buses):
    start, end, cost = map(int, input().split())
    graph[start].append((cost, end))

start_city, end_city = map(int, input().split())
distances = [INF] * (num_cities + 1)
previous_nodes = [i for i in range(num_cities + 1)]

def dijkstra(start):
    priority_queue = []
    heapq.heappush(priority_queue, (0, start))
    distances[start] = 0
    
    while priority_queue:
        current_cost, current_city = heapq.heappop(priority_queue)
        
        if distances[current_city] < current_cost:
            continue
        
        for neighbor_cost, neighbor_city in graph[current_city]:
            new_cost = current_cost + neighbor_cost
            
            if new_cost < distances[neighbor_city]:
                distances[neighbor_city] = new_cost
                heapq.heappush(priority_queue, (new_cost, neighbor_city))
                previous_nodes[neighbor_city] = current_city

def reconstruct_path(end):
    path = []
    current = end
    while True:
        path.append(current)
        if current == previous_nodes[current]:
            break
        current = previous_nodes[current]
    path.reverse()
    return path

# 다익스트라 알고리즘 실행
dijkstra(start_city)

# 최단 경로 및 경로 길이 출력
print(distances[end_city])
shortest_path = reconstruct_path(end_city)
print(len(shortest_path))
print(*shortest_path)
