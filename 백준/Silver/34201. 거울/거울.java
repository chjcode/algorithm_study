import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long s = Long.parseLong(st.nextToken());

        long[] a = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(a);

        long altSum = 0;
        int half = n / 2;

        for (int i = 0; i < half; i++) {
            altSum += (a[n - 1 - i] - a[i]);
        }
        if ((n & 1) == 1) {
            altSum += a[half];
        }

        long ans;
        if ((n & 1) == 0) {
            ans = s + 2L * altSum;
        } else {
            ans = -s + 2L * altSum;
        }

        System.out.println(ans);
    }
}
