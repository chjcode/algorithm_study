import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int u;
        int v;
        int w;
        Node(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.w, n.w);
        }
    }

    static int[] parent, rank;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Node[] nodes = new Node[m];
        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 1; i <= n; i++) parent[i] = i;

        long total = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(a, b, c);
            total += c;
        }

        Arrays.sort(nodes);

        long mst = 0;
        int used = 0;
        for (Node node : nodes) {
            if (union(node.u, node.v)) {
                mst += node.w;
                used++;
                if (used == n- 1) break;
            }
        }

        if (used != n - 1) {
            System.out.println(-1);
        } else {
            System.out.println(total - mst);
        }
    }
    
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return false;

        if (rank[pa] < rank[pb]) parent[pa] = pb;
        else if (rank[pa] > rank[pb]) parent[pb] = pa;
        else {
            parent[pb] = pa;
            rank[pa]++;
        }
        return true;
    }
}
