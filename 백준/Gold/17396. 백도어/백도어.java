import java.util.*;
import java.io.*;

public class Main {
    
    static class Node implements Comparable<Node> {
        int v;
        long cost;

        Node(int v, long cost) {
            this.v = v;
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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] watch = new int[n];
        for (int i = 0; i < n; i++) {
            watch[i] = Integer.parseInt(st.nextToken());
        }
        
        watch[n-1] = 0;
        
        List<List<Node>> lst = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            lst.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            
            lst.get(a).add(new Node(b,t));
            lst.get(b).add(new Node(a,t));
        }
        
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0,0));
        dist[0] = 0;
        
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            
            if (dist[now.v] < now.cost) continue;
            
            for (Node next : lst.get(now.v)) {
                if (watch[next.v] == 1) continue;    //감시중
                
                long newCost = dist[now.v] + next.cost;
                if (newCost < dist[next.v]) {
                    dist[next.v] = newCost;
                    pq.add(new Node(next.v, newCost));
                }
            }
        }
        
        if (dist[n-1] == Long.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dist[n-1]);
        }
    }
}