import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long[] time = new long[n];
        long mintime = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            time[i] = Long.parseLong(br.readLine());
            mintime = Math.min(mintime, time[i]);
        }

        long left = 0;
        long right = mintime * m;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;

            long cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += mid / time[i];
                if (cnt >= m) break;
            }

            if (cnt >= m) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
