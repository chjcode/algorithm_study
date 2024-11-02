
import java.util.*;
import java.io.*;

public class Solution {

    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < t + 1; tc++) {
            n = Integer.parseInt(br.readLine());

            int idx = 1;
            int bitmask = (1<<10) -1;
            int cnt = 0;
            while (true) {
                int temp = n * idx;
                while (temp > 0) {
                    cnt |= (1 << (temp % 10));
                    temp /= 10;
                }
                if (cnt == bitmask) break;
                idx++;
            }

            System.out.println("#" + tc + " " + idx*n);
        }
    }
}
