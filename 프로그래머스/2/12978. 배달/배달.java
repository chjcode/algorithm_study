import java.util.*;

class Solution {
    
    class Node implements Comparable<Node> {
        int node, cost;
        Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.cost, n.cost);
        }
    }    
    
    public int solution(int N, int[][] road, int K) {
        
        List<List<Node>> lst = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            lst.add(new ArrayList<>());
        }
        
        for (int[] r : road) {
            int u = r[0];
            int v = r[1];
            int c = r[2];
            
            lst.get(u).add(new Node(v,c));
            lst.get(v).add(new Node(u,c));
        }
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1,0));
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if (now.cost > dist[now.node]) continue;

            for (Node next : lst.get(now.node)) {
                int costSum = now.cost + next.cost;
                
                if (costSum < dist[next.node]) {
                    dist[next.node] = costSum;
                    pq.add(new Node(next.node, costSum));
                }
            }
        }
        
        int answer = 0;
        
        for (int i = 1; i < N+1; i++) {
            if (dist[i] <= K) answer++;
        }

        return answer;
    }
}