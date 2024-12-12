import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[] graph, answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        graph = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(graph);

        answer = new int[2];
        int left = 0;
        int right = n-1;
        int min = Integer.MAX_VALUE;
        while (left < right) {

            // 두 용액의 합이 크면
            int sum = graph[right] + graph[left];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                answer[0] = graph[left];
                answer[1] = graph[right];
            }

            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {
                break;
            }

        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}
