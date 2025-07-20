import java.util.*;
import java.io.*;

public class Main {
    
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
    static int n,m,a,b;
    static long c;
    static List<List<Node>> lst;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());    // 시작
        b = Integer.parseInt(st.nextToken());    // 끝
        c = Long.parseLong(st.nextToken());    // 가진 돈
        
        lst = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            lst.add(new ArrayList<>());
        }
        
        long maxCost = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long cost = Integer.parseInt(st.nextToken());
            lst.get(u).add(new Node(v, cost));
            lst.get(v).add(new Node(u, cost));
            maxCost = Math.max(maxCost, cost);
        }
        
        long left = 0;
        long right = maxCost;
        long result = -1;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (dijkstra(mid) <= c) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        System.out.println(result);
    }
    
    private static long dijkstra(long maxShame) {
        long[] dist = new long[n+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[a] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(a,0));
        
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            
            if (dist[now.idx] < now.cost) continue;
            
            for (Node next : lst.get(now.idx)) {
                if (next.cost > maxShame) continue;
                long sum = dist[now.idx] + next.cost;
                if (sum < dist[next.idx] && sum <= c) {
                    dist[next.idx] = sum;
                    pq.add(new Node(next.idx, sum));
                }
            }
        }
        
        return dist[b];
    }
}