import java.util.*;
import java.io.*;

public class Main {

    static int n,m;
    static int[] graph;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(graph);

        m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int card = Integer.parseInt(st.nextToken());
            // count = upperbound index - lowerbound index
            int count = upperbound(card) - lowerbound(card);
            sb.append(count).append(" ");
        }
        System.out.println(sb);
    }

    private static int upperbound(int card) {
        int left = 0;
        int right = graph.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (graph[mid] <= card) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private static int lowerbound(int card) {
        int left = 0;
        int right = graph.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (graph[mid] >= card) {
                right = mid;
            } else {
                left = mid+1;
            }
        }

        return left;
    }
}
