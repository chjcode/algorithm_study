import java.util.*;
import java.io.*;

public class Main {
    static int t,n,m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(Integer.parseInt(st.nextToken()));
            }
            m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                if (set.contains(Integer.parseInt(st.nextToken()))){
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
