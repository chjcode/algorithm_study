import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] w;
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        w = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) w[i] = Integer.parseInt(st.nextToken());

        dfs(0, 0, 0);

        if (result.isEmpty()) {
            System.out.println(-1);
            return;
        }

        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        int prev = -1;
        for (int x : result) {
            if (x != prev) {
                sb.append(x).append(' ');
                prev = x;
            }
        }
        System.out.println(sb.toString().trim());
    }

    static void dfs(int idx, int picked, int sum) {
        if (picked == m) {
            if (isPrime(sum)) result.add(sum);
            return;
        }
        if (idx == n) return;

        dfs(idx + 1, picked + 1, sum + w[idx]);
        dfs(idx + 1, picked, sum);
    }

    static boolean isPrime(int x) {
        if (x < 2) return false;
        if (x % 2 == 0) return x == 2;
        for (int d = 3; d * d <= x; d += 2)
            if (x % d == 0) return false;
        return true;
    }
}
