
import java.io.*;
import java.util.*;

public class Main {

    static int n,m,x;
    static List<List<Node>> graph, rGraph;
    static int[] times, rTimes;

    static class Node implements Comparable<Node>{
        int node;
        int time;
        Node(int node, int time) {
            this.node = node;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.time, o.time);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 학생 수 ( 마을 수 ) (노드)
        m = Integer.parseInt(st.nextToken());   // 단방향 도로(간선)
        x = Integer.parseInt(st.nextToken());   // 파티 장소

        graph = new ArrayList<>(n+1);  // 일반 그래프
        rGraph = new ArrayList<>(n+1); // 반대 그래프
        for( int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
            rGraph.add(new ArrayList<>());
        }

        times = new int[n+1];
        rTimes = new int[n + 1];
        for(int i = 0; i < n+1; i++){
            times[i] = Integer.MAX_VALUE;
            rTimes[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < m + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, time));
            rGraph.get(v).add(new Node(u, time));
        }

        dijkstra(graph, times, x);
        dijkstra(rGraph, rTimes, x);

        int maxTime = -1;
        for (int i = 1; i <= n; i++) {
            maxTime = Math.max(maxTime, times[i] + rTimes[i]);
        }

        System.out.println(maxTime);

    }

    private static void dijkstra(List<List<Node>> graph, int[] dist, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int currentNodeIndex = currentNode.node;

            for (Node neighbor : graph.get(currentNodeIndex)) {
                if (dist[neighbor.node] > dist[currentNodeIndex] + neighbor.time) {
                    dist[neighbor.node] = dist[currentNodeIndex] + neighbor.time;
                    pq.add(new Node(neighbor.node, dist[neighbor.node]));
                }
            }
        }
    }
}
