class Solution:
    def smallestEquivalentString(self, s1: str, s2: str, baseStr: str) -> str:

        def find(x):
            if x not in parent: # 처음 만나는 노드는
                parent[x] = x   # 자기 자신을 부모로 설정
            while x != parent[x]:   # 최상단의 부모를 찾을 때까지 탐색 반복
                x = parent[x]
            return x    # 최상단의 부모 return
        
        def union(a,b):
            ra = find(a)    # a의 부모 노드 찾기
            rb = find(b)    # b의 부모 노드 찾기
            parent[ra] = parent[rb] = min(ra,rb)    #작은 값을 부모 노드로
        
        parent = {}
        # union 함수로 각 element별로 부모 노드 찾기
        for c1,c2 in zip(s1,s2):
            union(c1,c2)
        
        # baseStr의 각 element를 부모 노드로 대체
        result = []
        for c in baseStr:
            result.append(parent[find(c)])
        return ''.join(result)