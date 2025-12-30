import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            long first = Long.parseLong(br.readLine());
            long bestEndingHere = first;
            long best = first;

            for (int i = 1; i < n; i++) {
                long x = Long.parseLong(br.readLine());

                bestEndingHere = Math.max(x, bestEndingHere + x);
                best = Math.max(best, bestEndingHere);
            }

            sb.append(best).append('\n');
        }

        System.out.print(sb.toString());
    }
}
