import java.util.*;
import java.io.*;

public class Main {
    static int n,e;
    static int[] cost;
    static List<List<Node>> lst;
    static class Node implements Comparable<Node> {
        int node;
        int cost;

        Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n  = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        lst = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            lst.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            lst.get(a).add(new Node(b,c));
            lst.get(b).add(new Node(a,c));
        }

        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        //반드시 거쳐야하면 해당지점까지의 최단거리를 구하면 되잖아

        long answer1 = 0L;
        answer1 += dijkstra(1,u);
        answer1 += dijkstra(u,v);
        answer1 += dijkstra(v,n);

        long answer2 = 0L;
        answer2 += dijkstra(1,v);
        answer2 += dijkstra(v,u);
        answer2 += dijkstra(u,n);

        long result = Math.min(answer1, answer2);

        if (result >= Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        cost = new int[n+1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        cost[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.node == end) return cost[end];

            for (Node next : lst.get(now.node)) {
                int newCost = cost[now.node] + next.cost;

                if (newCost < cost[next.node]) {
                    cost[next.node] = newCost;
                    pq.add(new Node(next.node, newCost));
                }
            }
        }
        return cost[end];
    }
}
