import java.util.*;
import java.io.*;

public class Main {
    
    static class Node implements Comparable<Node> {
        int node;
        int cost;
        Node (int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.cost, n.cost);
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        List<List<Node>> lst = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            lst.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            lst.get(u).add(new Node(v,c));
            lst.get(v).add(new Node(u,c));
        }
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s,0));
        dist[s] = 0;
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
        
            
            if (now.cost > dist[now.node]) continue;
            
            for (Node next : lst.get(now.node)) {
                if (dist[now.node] + next.cost < dist[next.node]) {
                    dist[next.node] = dist[now.node] + next.cost;
                    pq.add(new Node(next.node, dist[now.node] + next.cost));
                }
            }
            
            
        }
        
        System.out.println(dist[t]);
    }
}