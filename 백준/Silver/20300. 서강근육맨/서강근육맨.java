import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        long[] a = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Long.parseLong(st.nextToken());

        Arrays.sort(a);

        long ans = 0L;
        int left = 0, right = n - 1;

        if ((n & 1) == 1) {
            ans = Math.max(ans, a[right]);
            right--;
        }

        while (left < right) {
            ans = Math.max(ans, a[left] + a[right]);
            left++;
            right--;
        }

        System.out.println(ans);
    }
}
