import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] now, target;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        now = new int[n];
        target = new int[n];

        String s1 = br.readLine();
        String s2 = br.readLine();
        for (int i = 0; i < n; i++) {
            now[i] = s1.charAt(i) - '0';
            target[i] = s2.charAt(i) - '0';
        }

        int result1 = simulate(Arrays.copyOf(now, n), false);

        // 첫 번째 스위치를 누른 경우
        int result2 = simulate(Arrays.copyOf(now, n), true);

        // 결과 출력
        if (result1 == -1 && result2 == -1) {
            System.out.println(-1);
        } else if (result1 == -1) {
            System.out.println(result2);
        } else if (result2 == -1) {
            System.out.println(result1);
        } else {
            System.out.println(Math.min(result1, result2));
        }
    }

    private static int simulate(int[] arr, boolean pressFirst) {
        int cnt = 0;

        // 첫 번째 스위치를 누른 경우
        if (pressFirst) {
            cnt++;
            arr[0] = 1 - arr[0];
            if (n > 1) arr[1] = 1 - arr[1];
        }

        // 두 번째 스위치부터 처리
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != target[i]) {
                cnt++;
                arr[i] = 1 - arr[i];
                arr[i + 1] = 1 - arr[i + 1];
                if (i + 2 < n) {
                    arr[i + 2] = 1 - arr[i + 2];
                }
            }
        }

        // 마지막 전구 확인
        return arr[n - 1] != target[n - 1] ? -1 : cnt;
    }
}