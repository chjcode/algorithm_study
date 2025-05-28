import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] h = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(h);

        long minDiff = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                long snowman1 = h[i] + h[j];

                int left = 0;
                int right = n - 1;

                while (left < right) {
                    if (left == i || left == j) {
                        left++;
                        continue;
                    }
                    if (right == i || right == j) {
                        right--;
                        continue;
                    }

                    if (left >= right) {
                        break;
                    }

                    long snowman2 = h[left] + h[right]; // H -> h
                    long currentDiff = snowman1 - snowman2;

                    minDiff = Math.min(minDiff, Math.abs(currentDiff));

                    if (currentDiff == 0) {
                        System.out.println(0);
                        return;
                    } else if (currentDiff > 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        System.out.println(minDiff);
    }
}