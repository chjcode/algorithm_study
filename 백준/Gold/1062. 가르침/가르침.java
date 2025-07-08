import java.io.*;

public class Main {

    static int N, K;
    static String[] words;
    static boolean[] learned = new boolean[26];
    static int maxCount = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        N = Integer.parseInt(NK[0]);
        K = Integer.parseInt(NK[1]);

        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        if (K < 5) {
            System.out.println(0);
            return;
        }

        learned['a' - 'a'] = true;
        learned['n' - 'a'] = true;
        learned['t' - 'a'] = true;
        learned['i' - 'a'] = true;
        learned['c' - 'a'] = true;

        dfs(0, 0);
        System.out.println(maxCount);
    }

    public static void dfs(int idx, int count) {
        if (count == K - 5) {
            int currentCount = 0;
            for (String word : words) {
                boolean canRead = true;
                for (char c : word.toCharArray()) {
                    if (!learned[c - 'a']) {
                        canRead = false;
                        break;
                    }
                }
                if (canRead) {
                    currentCount++;
                }
            }
            maxCount = Math.max(maxCount, currentCount);
            return;
        }

        if (idx >= 26) {
            return;
        }

        if (!learned[idx]) {
            learned[idx] = true;
            dfs(idx + 1, count + 1);
            learned[idx] = false;
        }

        dfs(idx + 1, count);
    }
}