import java.util.*;
import java.io.*;

public class Main {
    static int n,x,y;
    static Line[] graph;
    static class Line implements Comparable<Line>{
        int x;
        int y;
        Line(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Line l) {
            return Integer.compare(this.x, l.x);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new Line[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph[i] = new Line(x, y);
        }

        Arrays.sort(graph);

        int beforeX = graph[0].x;
        int beforeY = graph[0].y;
        int answer = beforeY - beforeX;
        for (int i = 1; i < n; i++) {
            if (beforeX <= graph[i].x && graph[i].x <= beforeY && beforeY <= graph[i].y) {
                answer += graph[i].y - beforeY;
                beforeY = graph[i].y;
            } else if (beforeY < graph[i].x) {
                answer += graph[i].y-graph[i].x;
                beforeX = graph[i].x;
                beforeY = graph[i].y;
            }
        }
        System.out.println(answer);
    }
}
