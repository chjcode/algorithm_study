import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[] parent;

    static class Line implements Comparable<Line> {
        int start;
        int end;
        double dist;

        Line (int start, int end, double dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Line o) {
            return (int)(dist - o.dist);
        }
    }

    static class Star {
        double x;
        double y;
        Star(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        parent = new int[n];
        for (int i = 1; i < n; i++) {
            parent[i] = i;
        }

        Star[] stars = new Star[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            float x = Float.parseFloat(st.nextToken());
            float y = Float.parseFloat(st.nextToken());
            stars[i] = new Star(x, y);
        }

        PriorityQueue<Line> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                double dist = Math.sqrt((stars[i].x - stars[j].x) * (stars[i].x - stars[j].x) + (stars[i].y - stars[j].y) * (stars[i].y - stars[j].y));

                pq.add(new Line(i,j,dist));
            }
        }

        float answer = 0;
        while(!pq.isEmpty()) {
            Line line = pq.poll();

            if (find(line.start) != find(line.end)) {
                union(line.start, line.end);
                answer += line.dist;
            }
        }

        System.out.printf("%.2f", answer);
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }
}
