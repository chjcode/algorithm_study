import java.util.*;
import java.io.*;

public class Main {
    
    static int n, m, a, b;
    static List<List<Node>> graph;
    static long[] distA, distB;
    
    static class Node implements Comparable<Node> {
        int idx;
        long cost;
        Node(int idx, long cost) {
            this.idx = idx;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node n) {
            return Long.compare(this.cost, n.cost);
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
    
        graph = new ArrayList<>();
        for (int i = 0;i < n+1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, cost));
            graph.get(v).add(new Node(u, cost));
        }
    
        distA = dijkstra(a);
        
        distB = dijkstra(b);
        
        long minDistAToB = distA[b];
        
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 1; i < n+1; i++) {
            if (distA[i] + distB[i] == minDistAToB) {
                cnt++;
                sb.append(i).append(" ");
            }
        }
        
        System.out.println(cnt);
        System.out.println(sb.toString().trim());
    }
    
    private static long[] dijkstra (int start) {
        long[] dist = new long[n+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            
            if (now.cost > dist[now.idx]) continue;
            
            for (Node next : graph.get(now.idx)) {
                if (dist[next.idx] > dist[now.idx] + next.cost) {
                    dist[next.idx] = dist[now.idx] + next.cost;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }
        
        return dist;
    }
}