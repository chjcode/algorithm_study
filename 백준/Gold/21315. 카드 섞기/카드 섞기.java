import java.io.*;
import java.util.*;

public class Main {
    static int n, maxk;
    static int[] target;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        target = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) target[i] = Integer.parseInt(st.nextToken());

        maxk = 0;
        for (int k = 1, p = 2; p < n; k++, p *= 2) maxk = k;

        int[] init = new int[n];
        for (int i = 0; i < n; i++) init[i] = i + 1;

        for (int k1 = 1; k1 <= maxk; k1++) {
            int[] after1 = shuffle(init, k1);
            for (int k2 = 1; k2 <= maxk; k2++) {
                int[] after2 = shuffle(after1, k2);
                if (Arrays.equals(after2, target)) {
                    System.out.println(k1 + " " + k2);
                    return;
                }
            }
        }
    }

    static int[] shuffle(int[] deck, int k) {
        int n = deck.length;
        int t = 1 << k; // 2^k
        int[] res = new int[n];

        int idx = 0;
        for (int i = n - t; i < n; i++) res[idx++] = deck[i];
        for (int i = 0; i < n - t; i++) res[idx++] = deck[i];

        int pos = t;

        for (int s = k - 1; s >= 0; s--) {
            int size = 1 << s;
            int[] next = new int[n];
            int p = 0;

            for (int i = pos - size; i < pos; i++) next[p++] = res[i];
            for (int i = 0; i < pos - size; i++) next[p++] = res[i];
            for (int i = pos; i < n; i++) next[p++] = res[i];

            res = next;
            pos = size;
        }
        return res;
    }
}
