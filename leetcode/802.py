class Solution(object):
    def eventualSafeNodes(self, graph):

        def dfs(i):
            if i in safe:
                return safe[i]
            safe[i] = False
            for neighbor in graph[i]:
                if not dfs(neighbor):
                    return False
            safe[i] = True
            return True

        n = len(graph)
        safe = {}
        safe_nodes = []
        for i in range(n):
            if dfs(i):
                safe_nodes.append(i)
        return safe_nodes