import java.util.*;
import java.io.*;


public class Main {

    static int[] parent;

    static class Line implements Comparable<Line> {
        int u;
        int v;
        int cost;

        Line (int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Line l) {
            return this.cost - l.cost;
        }
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        parent = new int[v+1];
        for (int i = 1; i < v+1; i++) {
            parent[i] = i;
        }

        PriorityQueue<Line> pq = new PriorityQueue<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            pq.add(new Line(a,b,c));
        }

        int answer = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            Line line = pq.poll();
            if (find(line.u) != find(line.v)) {
                union(line.u, line.v);
                cnt++;
                answer += line.cost;
            }
        }

        System.out.println(answer);

    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}
