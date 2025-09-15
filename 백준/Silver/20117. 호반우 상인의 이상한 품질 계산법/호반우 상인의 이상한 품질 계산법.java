import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long answer = 0;
        int l = 0;
        int r = n - 1;

        while (l < r) {
            answer += 2L * arr[r];
            l++;
            r--;
        }

        if (l == r) {
            answer += arr[l];
        }

        System.out.println(answer);
    }
}
