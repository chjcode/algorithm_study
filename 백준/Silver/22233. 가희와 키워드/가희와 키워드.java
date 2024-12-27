import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static Set<String> memo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        memo = new HashSet<>();

        for (int i = 0; i < n; i++) {
            memo.add(br.readLine());
        }

        int cnt = n;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), ",");

            while(st.hasMoreTokens()) {
                String s = st.nextToken();
                if (memo.contains(s)) {
                    memo.remove(s);
                    cnt--;
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
