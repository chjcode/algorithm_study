import sys
import heapq

input = sys.stdin.readline
INF = sys.maxsize

def dijkstra(start):
    distances[start] = 0
    min_heap = [(0, start)]
    
    while min_heap:
        current_weight, current_node = heapq.heappop(min_heap)
        
        if distances[current_node] < current_weight:
            continue
        
        for weight, neighbor in graph[current_node]:
            new_weight = current_weight + weight
            
            if new_weight < distances[neighbor]:
                distances[neighbor] = new_weight
                heapq.heappush(min_heap, (new_weight, neighbor))

# 입력
num_vertices, num_edges = map(int, input().split())
start_vertex = int(input())

# 가중치 테이블 초기화
distances = [INF] * (num_vertices + 1)
graph = [[] for _ in range(num_vertices + 1)]

# 그래프 초기화
for _ in range(num_edges):
    u, v, weight = map(int, input().split())
    graph[u].append((weight, v))

# 다익스트라 알고리즘 실행
dijkstra(start_vertex)

# 결과 출력
for i in range(1, num_vertices + 1):
    print("INF" if distances[i] == INF else distances[i])
