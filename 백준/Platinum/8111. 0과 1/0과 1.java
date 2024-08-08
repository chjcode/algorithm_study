
import java.util.*;
import java.io.*;

public class Main {

    static class Pair {
        String num;
        int mod;

        Pair(String num, int mod) {
            this.num = num;
            this.mod = mod;
        }
    }

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            System.out.println(findMultiple());
        }
    }

    private static String findMultiple() {
        if (n == 1) return "1";

        Deque<Pair> deq = new ArrayDeque<>();
        deq.offerLast(new Pair("1", 1%n));

        boolean[] visited = new boolean[n];
        visited[1 % n] = true;

        while (!deq.isEmpty()) {
            Pair pair = deq.poll();

            if (pair.mod == 0) {
                return pair.num;
            }

            int mod0 = (pair.mod*10) % n;
            if (!visited[mod0]) {
                deq.offerLast(new Pair(pair.num + "0", mod0));
                visited[mod0] = true;
            }

            int mod1 = (pair.mod * 10 + 1) % n;
            if (!visited[mod1]) {
                deq.offerLast(new Pair(pair.num + "1", mod1));
                visited[mod1] = true;
            }
        }

        return "BRAK";
    }
}
