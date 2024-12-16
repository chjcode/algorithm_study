import java.util.*;
import java.io.*;

public class Main {

    static int n,d,w;
    static Homework[] graph;

    static class Homework implements Comparable<Homework>{
        int d;
        int w;
        Homework(int d, int w) {
            this.d = d;
            this.w = w;
        }

        @Override
        public int compareTo(Homework h) {
            return h.w - this.w;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        graph = new Homework[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            graph[i] = new Homework(d,w);
        }

        Arrays.sort(graph);

        int[] order = new int[1001];

        int total = 0;
        for (int i =0; i < n; i++) {
            for (int j = graph[i].d; j > 0; j--) {
                if (order[j] == 0) {
                    order[j] = graph[i].w;
                    total += graph[i].w;
                    break;
                }
            }
        }

        System.out.println(total);

    }
}
