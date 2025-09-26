import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] xs = new int[N];
        int[] gs = new int[N];
        int maxX = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            gs[i] = g;
            xs[i] = x;
            if (x > maxX) maxX = x;
        }

        int[] ice = new int[maxX + 1];
        for (int i = 0; i < N; i++) ice[xs[i]] += gs[i];

        int w = 2 * K + 1;
        long best = 0, curr = 0;
        int L = 0;

        for (int R = 0; R <= maxX; R++) {
            curr += ice[R];
            while (R - L + 1 > w) curr -= ice[L++];
            if (curr > best) best = curr;
        }

        System.out.println(best);
    }
}
