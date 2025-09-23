import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int next, cost;
        Edge(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }

    static List<List<Edge>> adj;
    static boolean[] seen;
    static final int LIMIT = 1_000_000_000;

    static int solve(int cur) {
        seen[cur] = true;
        int total = 0;
        boolean leaf = true;

        for (Edge e : adj.get(cur)) {
            if (seen[e.next]) continue;
            leaf = false;
            int down = solve(e.next);
            int cut  = e.cost;
            total += Math.min(down, cut);
        }

        if (leaf) return LIMIT;
        return total;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            adj = new ArrayList<>(n + 1);
            for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                adj.get(a).add(new Edge(b, c));
                adj.get(b).add(new Edge(a, c));
            }

            if (n == 1 || m == 0) {
                sb.append(0).append('\n');
                continue;
            }

            seen = new boolean[n + 1];
            int ans = solve(1);
            if (ans >= LIMIT) ans = 0;
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}