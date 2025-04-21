import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        int len = wires.length;
        
        for (int pass = 0; pass < len; pass++) {
            List<List<Integer>> lst = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                lst.add(new ArrayList<>());
            }

            for (int i = 0; i < len; i++) {
                if (i == pass) continue;
                int u = wires[i][0];
                int v = wires[i][1];
                lst.get(u).add(v);
                lst.get(v).add(u);
            }

            boolean[] visited = new boolean[n + 1];
            int cnt = dfsCount(1, lst, visited);

            int other = n - cnt;
            answer = Math.min(answer, Math.abs(cnt - other));
        }
        
        return answer;
    }

    private int dfsCount(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        int count = 1;
        for (int nxt : graph.get(node)) {
            if (!visited[nxt]) {
                count += dfsCount(nxt, graph, visited);
            }
        }
        return count;
    }
}
