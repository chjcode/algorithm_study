import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[n];
        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[d + 1];
        int cnt = 0;

        for (int i = 0; i < k; i++) {
            if (count[sushi[i]] == 0) cnt++;
            count[sushi[i]]++;
        }

        int max = cnt;
        if (count[c] == 0) max++;

        for (int i = 1; i < n; i++) {
            int remove = sushi[(i - 1) % n];
            int add = sushi[(i + k - 1) % n];

            count[remove]--;
            if (count[remove] == 0) cnt--;

            if (count[add] == 0) cnt++;
            count[add]++;

            int current = cnt;
            if (count[c] == 0) current++;

            max = Math.max(max, current);
        }

        System.out.println(max);
    }
}
