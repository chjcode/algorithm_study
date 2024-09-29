
import java.util.*;
import java.io.*;

public class Main {
    static int tc, n;
    static int[] graph;

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            n = Integer.parseInt(br.readLine());

            graph = new int[n];

            for (int i = 0;i < n; i++) {
                graph[i] = i+1;
            }

            dfs(0, new StringBuilder().append(graph[0]));
            System.out.println();
        }

    }

    private static void dfs(int depth, StringBuilder sb) {

        if (depth == n-1) {
            String s = sb.toString();
            if (calculate(s) == 0) {
                System.out.println(s);
            }
            return;
        }

        dfs(depth+1, new StringBuilder(sb).append(" ").append(graph[depth+1]));
        dfs(depth+1, new StringBuilder(sb).append("+").append(graph[depth+1]));
        dfs(depth+1, new StringBuilder(sb).append("-").append(graph[depth+1]));

    }

    private static int calculate(String s) {
        s = s.replace(" ", "");
        StringTokenizer st = new StringTokenizer(s, "+-",true);

        int num = Integer.parseInt(st.nextToken());
        int result = num;

        while (st.hasMoreTokens()) {
            String operator = st.nextToken();
            num = Integer.parseInt(st.nextToken());

            if (operator.equals("+")) {
                result += num;
            } else{
                result -= num;
            }
        }

        return result;
    }
}
