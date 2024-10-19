
import java.util.*;
import java.io.*;

public class Main {

    static int n,m,sum,max;
    static long answer;
    static int[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        graph = new int[n];
        st = new StringTokenizer(br.readLine());
        sum = 0;
        max = 0;
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            graph[i] = temp;
            sum += temp;
            max = Math.max(max,temp);
        }
        m = Integer.parseInt(br.readLine());

        if (sum <= m) {
            System.out.println(max);
        } else {
            answer = binarySearch();
            System.out.println(answer);
        }
    }

    private static int binarySearch() {
        int left = 1;
        int right = max;

        while (left <= right) {
            int mid = (left + right) / 2;
            long cnt = 0;
            for (int i = 0; i < n; i++) {
                if (graph[i] < mid) {
                    cnt += graph[i];
                } else {
                    cnt += mid;
                }
                if (cnt > m) break;
            }
            // m보다 작으면 다음 예산으로 검색
            if (cnt <= m) {
                left = mid+1;
            }else {
                right = mid-1;
            }
        }

        return left-1;
    }
}
