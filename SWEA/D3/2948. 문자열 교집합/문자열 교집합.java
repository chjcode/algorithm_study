
import java.util.*;
import java.io.*;

public class Solution {
    static int n,m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc < t + 1; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            Set<String> set = new HashSet<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i< n; i++) {
                set.add(st.nextToken());
            }

            int answer = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                String s = st.nextToken();
                if (set.contains(s)) {
                    answer++;
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
