import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] tree;
    static int[] sub;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        tree = new ArrayList[n + 1]; 
        sub = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <=n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree[u].add(v);
            tree[v].add(u);
        }


        dfs(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int query = Integer.parseInt(br.readLine());
            sb.append(sub[query]).append('\n');
        }

        System.out.print(sb);
    }

    static int dfs(int node) {
        visited[node] = true;
        int size = 1;

        for (int child : tree[node]) {
            if (!visited[child]) {
                size += dfs(child);  
            }
        }

        sub[node] = size;
        return size;
    }
}
