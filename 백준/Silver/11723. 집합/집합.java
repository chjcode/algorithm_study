import java.io.*;
import java.util.*;

public class Main {
    static int m;
    static Set<Integer> set;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        set = new HashSet<>();
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if (s.equals("add")) {
                int num = Integer.parseInt(st.nextToken());
                set.add(num);
            } else if (s.equals("remove")) {
                int num = Integer.parseInt(st.nextToken());
                if (set.contains(num)) {
                    set.remove(num);
                }
            } else if (s.equals("check")) {
                int num = Integer.parseInt(st.nextToken());
                if (set.contains(num)) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (s.equals("toggle")) {
                int num = Integer.parseInt(st.nextToken());
                if (set.contains(num)) {
                    set.remove(num);
                } else {
                    set.add(num);
                }
            } else if (s.equals("all")) {
                set = new HashSet<>();
                for (int j = 1; j < 21; j++) {
                    set.add(j);
                }
            } else if (s.equals("empty")) {
                set = new HashSet<>();
            }
        }
        System.out.println(sb.toString());
    }
}
