import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static int[] trees;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        trees = new int[n];
        int maxH = 0;
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            maxH = Math.max(maxH, trees[i]);
        }

        int left = 0;
        int right = maxH;
        int answer = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            long total = calH(mid);
            if (total < m) {    // 더 낮게 지정해야 많은 나무를 들고 감
                right = mid - 1;
            } else {
                answer = mid;
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private static long calH(int h) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int temp = trees[i] - h;
            if (temp > 0) {
                sum += temp;
            }
        }

        return sum;
    }
}
