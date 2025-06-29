import java.util.*;
import java.io.*;

public class Main {
    
    static class Node{
        int v;
        long cost;
        Node(int v, long cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(v).add(new Node(u, cost));
        }
        
        int[] place = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            place[i] = Integer.parseInt(st.nextToken());
        }
        
        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(node -> node.cost));
        
        for (int i = 0; i < k; i++) {
            int interview = place[i];
            dist[interview] = 0;
            pq.offer(new Node(interview, 0));
        }

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (now.cost > dist[now.v]) continue;

            for (Node next : graph.get(now.v)) {
                if (dist[next.v] > dist[now.v] + next.cost) {
                    dist[next.v] = dist[now.v] + next.cost;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }
        
        long maxDist = -1;
        int location = -1;
        for (int i = 1; i <= n; i++) {
            if (dist[i] > maxDist) {
                maxDist = dist[i];
                location = i;
            }
        }

        System.out.println(location);
        System.out.println(maxDist);
        
    }
}