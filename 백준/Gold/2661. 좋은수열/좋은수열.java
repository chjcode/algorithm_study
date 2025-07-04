import java.io.*;

public class Main {

    static int n;
    static int[] arr;
    static boolean isEnd = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dfs(0);
    }

    private static void dfs(int depth) {
        if (isEnd) return;

        if (depth == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i]);
            }
            isEnd = true;
            return;
        }

        for (int j = 1; j <= 3; j++) {
            arr[depth] = j;

            if (isGood(depth)) {
                dfs(depth + 1);
            }
        }
    }

    private static boolean isGood(int depth) {
        for (int i = 1; i <= (depth + 1) / 2; i++) {
            boolean isSame = true;
            for (int j = 0; j < i; j++) {
                if (arr[depth - j] != arr[depth - i - j]) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) return false;
        }
        return true;
    }
}
