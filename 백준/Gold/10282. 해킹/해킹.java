import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node> {
        int idx;
        int cost;
        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.cost, n.cost);
        }
    }

    static List<List<Node>> lst;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
            int d = Integer.parseInt(st.nextToken()); // 의존성 개수
            int c = Integer.parseInt(st.nextToken()); // 시작(해킹당한) 컴퓨터

            lst = new ArrayList<>();
            for (int i = 0; i <= n; i++) lst.add(new ArrayList<>());

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                lst.get(b).add(new Node(a, s));
            }

            int[] dist = new int[n + 1];
            Arrays.fill(dist, INF);
            dist[c] = 0;

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(c, 0));

            while (!pq.isEmpty()) {
                Node cur = pq.poll();

                if (cur.cost != dist[cur.idx]) continue;

                for (Node next : lst.get(cur.idx)) {
                    int nd = cur.cost + next.cost;
                    if (nd < dist[next.idx]) {
                        dist[next.idx] = nd;
                        pq.offer(new Node(next.idx, nd));
                    }
                }
            }

            int computer = 0;
            int maxTime = 0;
            for (int i = 1; i <= n; i++) {
                if (dist[i] != INF) {
                    computer++;
                    if (dist[i] > maxTime) maxTime = dist[i];
                }
            }

            sb.append(computer).append(' ').append(maxTime).append('\n');
        }

        System.out.print(sb.toString());
    }
}
