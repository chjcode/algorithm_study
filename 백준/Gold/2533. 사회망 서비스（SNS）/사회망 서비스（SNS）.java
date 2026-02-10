import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] parent = new int[n + 1];
        Arrays.fill(parent, 0);
        parent[1] = -1;

        int[] order = new int[n];
        int ordSize = 0;

        int[] stack = new int[n];
        int sp = 0;
        stack[sp++] = 1;

        while (sp > 0) {
            int u = stack[--sp];
            order[ordSize++] = u;

            for (int v : adj.get(u)) {
                if (v == parent[u]) continue;
                if (parent[v] != 0) continue; 
                parent[v] = u;
                stack[sp++] = v;
            }
        }

        int[] dp0 = new int[n + 1];
        int[] dp1 = new int[n + 1];

        for (int i = ordSize - 1; i >= 0; i--) {
            int u = order[i];
            dp1[u] = 1;

            for (int v : adj.get(u)) {
                if (v == parent[u]) continue;
                dp0[u] += dp1[v];
                dp1[u] += Math.min(dp0[v], dp1[v]);
            }
        }

        System.out.println(Math.min(dp0[1], dp1[1]));
    }
}
