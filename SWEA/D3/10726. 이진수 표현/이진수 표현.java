import java.util.*;
import java.io.*;

public class Solution {
    static long n;
    static long m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc < t+1; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Long.parseLong(st.nextToken());
            m = Long.parseLong(st.nextToken());
            String answer = "OFF";
            if ((m & ((1<<n)-1)) == ((1<<n)-1)) {
                answer = "ON";
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
