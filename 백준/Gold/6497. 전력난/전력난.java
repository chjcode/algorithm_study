import java.util.*;
import java.io.*;

public class Main{

    static class Node implements Comparable<Node>{
        int u;
        int v;
        int cost;
        Node(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }

    static int m,n;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        while(true) {

            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            if (m == 0 && n == 0) break;

            parent = new int[m];
            for (int i = 1; i < m; i++) {
                parent[i] = i;
            }

            int total = 0;
            PriorityQueue<Node> pq = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                pq.add(new Node(x,y,z));
                total += z;
            }

            int cnt = 0;
            while(!pq.isEmpty()) {
                Node node = pq.poll();
                if (find(node.u) != find(node.v)) {
                    union(node.u, node.v);
                    cnt += node.cost;
                }
            }
            System.out.println(total-cnt);
        }

    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if (xRoot != yRoot) {
            parent[yRoot] = xRoot;
        }
    }
}