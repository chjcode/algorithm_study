import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k;
    static List<List<Node>> graph;
    static long[][] dist;
    static class Node implements Comparable<Node>{
        int node;    // 노드
        long t;      // 시간
        int cnt;    // 포장 개수

        Node(int node, long t, int cnt) {
            this.node = node;
            this.t = t;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node n) {
            return Long.compare(this.t, n.t);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());   // 포장할 도로의 수

        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long t = Long.parseLong(st.nextToken());

            graph.get(u).add(new Node(v,t,0));
            graph.get(v).add(new Node(u, t, 0));
        }

        dist = new long[n+1][k+1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        dist[1][0] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1,0,0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.t > dist[now.node][now.cnt]) continue;

            for (Node next : graph.get(now.node)) {
                // 도로 포장 o
                if (now.cnt < k && dist[now.node][now.cnt] < dist[next.node][now.cnt + 1]) {
                    dist[next.node][now.cnt+1] = dist[now.node][now.cnt];
                    pq.add(new Node(next.node, dist[next.node][now.cnt+1], now.cnt+1));
                }
                //도로 포장 x
                if (dist[now.node][now.cnt] + next.t < dist[next.node][now.cnt]) {
                    dist[next.node][now.cnt] = dist[now.node][now.cnt] + next.t;
                    pq.add(new Node(next.node, dist[next.node][now.cnt], now.cnt));
                }
            }
        }

        long min = Long.MAX_VALUE;
        for (int j = 0; j < k+1; j++) {

            min = Math.min(min, dist[n][j]);
        }
        System.out.println(min);
    }
}