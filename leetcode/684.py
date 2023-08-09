class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:

            #  방문 표시와 부모 노드를 동시에 기록할 리스트
            par = [0] * (len(edges)+1)  

            def find(x):
                if par[x] == 0: # 처음 방문
                    return x
                return find(par[x]) # 부모 노드를 재귀로 찾아 올라감

            for x, y in edges:
                u = find(x)
                v = find(y)
                if u == v:  # 부모 노드가 같으면 순환하게 되므로 해당 노드 반환
                    return [x, y]
                par[v] = u  # 자기 자신보다 작은 값을 부모로 설정