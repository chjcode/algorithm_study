# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def distanceK(self, root: TreeNode, target: TreeNode, k: int) -> List[int]:
        if k == 0:
            return [target.val]
        
        # 1. 트리를 그래프로 만들기
        graph = collections.defaultdict(list)
        
        deq = collections.deque([root])
        # print('deq: ',deq)

        while deq:
            node = deq.popleft()

            if node.left:
                '''
                자식 노드에서 부모 노드, 부모노드에서 자식노드
                양방향으로 이어져 있어야 하므로 모두 추가
                '''
                graph[node].append(node.left)
                graph[node.left].append(node)

                deq.append(node.left)   # 연결된 노드를 계속해서 추가해주기 위해

            if node.right:
                graph[node].append(node.right)
                graph[node.right].append(node)

                deq.append(node.right)

        # 2. 만든 그래프를 이용해 bfs탐색 
        result = [] # 결과를 저장할 리스트
        visited = set([target])    # 무한루프에 빠지지 않기 위한 방문 리스트

        deq = collections.deque([(target, 0)])

        while deq:
            node, distance = deq.popleft()

            if distance == k:
                result.append(node.val)
            else:
                for edge in graph[node]:
                    if edge not in visited:
                        visited.add(edge)
                        deq.append((edge, distance+1))
        
        return result
