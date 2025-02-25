import java.util.*;

class Solution {
    
    static int[] parent;
    
    static class Line implements Comparable<Line> {
        int u;
        int v;
        int cost;
        Line(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Line l) {
            return this.cost - l.cost;
        }
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        parent = new int[n];
        
        for (int i = 1; i < n; i++) {
            parent[i] = i;
        }
        
        PriorityQueue<Line> pq = new PriorityQueue<>();
        
        for (int[] cost : costs) {
            int u = cost[0];
            int v = cost[1];
            int c = cost[2];
            pq.add(new Line(u,v,c));        
        }
        
        int cnt = 0;
        while(!pq.isEmpty() && cnt < n-1) {
            Line line = pq.poll();
            
            if (find(line.u) != find(line.v)) {
                union(line.u, line.v);
                answer += line.cost;
                cnt++;
            }
        }

        return answer;
    }
    
    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        
        return parent[x] = find(parent[x]);
    }
    
    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}