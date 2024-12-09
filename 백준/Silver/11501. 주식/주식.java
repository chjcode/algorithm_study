import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine());
            graph = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                graph[i] = Integer.parseInt(st.nextToken());
            }

            int max = 0;
            long answer = 0;
            for (int i = n-1; i > -1; i--) {
                if (graph[i] > max) {
                    max = graph[i];
                } else {
                    answer += (max - graph[i]);
                }
            }

            System.out.println(answer);
        }
    }
}
