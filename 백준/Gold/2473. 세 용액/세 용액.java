import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static long min;
    static long[] graph;
    static long[] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            graph[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(graph);

        min = Long.MAX_VALUE;
        answer = new long[3];

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                long sum = graph[i] + graph[left] + graph[right];
                long absSum = Math.abs(sum);

                if (absSum < min) {
                    min = absSum;
                    answer[0] = graph[i];
                    answer[1] = graph[left];
                    answer[2] = graph[right];
                }

                if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        Arrays.sort(answer);
        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}
