# leetcode 1334 -> 플로이드 알고리즘

class Solution:
    def findTheCity(self, n: int, edges: List[List[int]], distanceThreshold: int) -> int:
        graph = [[int(2e9) for j in range(n)] for i in range(n)]
        for u,v,d in edges:
            graph[u][v] = d
            graph[v][u] = d
        for k in range(n):
            for i in range(n):
                for j in range(n):
                    if i == j:
                        graph[i][j] = 0
                    else:
                        graph[i][j] = min(graph[i][j], graph[i][k]+graph[k][j])
        answer = -1
        minimum = int(2e9)
        for i in range(n):
            cnt = 0
            for j in range(n):
                if graph[i][j] <= distanceThreshold and i!=j:
                    cnt+=1
            if cnt <= minimum:
                answer = i
                minimum = cnt
        return answer