import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long K;
    static long count = 0;
    static String answer = null;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());

        ArrayList<Integer> path = new ArrayList<>();
        dfs(0, path);

        System.out.println(answer == null ? -1 : answer);
    }

    static void dfs(int sum, ArrayList<Integer> path) {
        if (answer != null) return;
        if (sum == N) {
            count++;
            if (count == K) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < path.size(); i++) {
                    if (i > 0) sb.append('+');
                    sb.append(path.get(i));
                }
                answer = sb.toString();
            }
            return;
        }
        if (sum > N) return;

        for (int x = 1; x <= 3; x++) {
            path.add(x);
            dfs(sum + x, path);
            path.remove(path.size() - 1);
            if (answer != null) return;
        }
    }
}
