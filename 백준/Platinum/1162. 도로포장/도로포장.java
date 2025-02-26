import java.io.*;
import java.util.*;

public class Main {

    static int n, m, k;
    static List<List<Node>> graph;

    static class Node implements Comparable<Node> {
        int node;    // 현재 노드
        long time;    // 현재 노드까지 오는데 걸린 시간 누적
        int cnt;    // 현재까지 도로 포장 개수
        Node(int node, long time, int cnt) {
            this.node = node;
            this.time = time;
            this.cnt = cnt;
        }
        
        @Override
        public int compareTo(Node n) {
            return Long.compare(this.time, n.time);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long time = Long.parseLong(st.nextToken());

            graph.get(u).add(new Node(v,time,0));
            graph.get(v).add(new Node(u,time,0));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1,0,0));
        long[][] dist = new long[k+1][n+1];
        for(int i = 0; i < k+1; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }
        dist[0][1] = 0;    // [도로 포장 개수][idx]

        while (!pq.isEmpty()) {
            Node now = pq.poll();    //현재까지 걸린 시간이 가장 짧은 노드 추출
            
            // 현재까지 걸린 시간이 dist에 기록된 최단 시간보다 오래걸리면 continue;
            if (now.time > dist[now.cnt][now.node]) continue;
            // 먼저 도착지에 도착한 것이 최소시간이라는 보장이 안되는 이유?
            for (Node next : graph.get(now.node)) {
                // 도로 포장 안했을 때 다음 도시까지의 시간이 현재 기록된 시간보다 짧으면
                if (dist[now.cnt][next.node] > dist[now.cnt][now.node] + next.time) {
                    dist[now.cnt][next.node] = dist[now.cnt][now.node] + next.time;
                    pq.add(new Node(next.node, dist[now.cnt][next.node], now.cnt));
                }
                
                // 도로 포장했을 때 
                if (now.cnt < k && dist[now.cnt+1][next.node] > dist[now.cnt][now.node]) {
                    dist[now.cnt+1][next.node] = dist[now.cnt][now.node];
                    pq.add(new Node(next.node, dist[now.cnt+1][next.node], now.cnt+1));
                }
            }
            
        }
        
        long minTime = Long.MAX_VALUE;
        for (int i = 0; i < k+1; i++) {
            minTime = Math.min(minTime, dist[i][n]);
        }
        System.out.println(minTime);
    }
}
