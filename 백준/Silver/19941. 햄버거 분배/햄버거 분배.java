import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static char[] graph;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new char[n];
        String s = br.readLine();
        for (int i = 0; i < n; i++) {
            graph[i] = s.charAt(i);
        }

        // p를 먼저 찾고, p가 먹을 수 있는 햄버거 중
        // 가장 왼쪽 햄버거 찾기
        // 먹은 개수만큼 cnt++
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (graph[i] == 'P') {
                for (int j = Math.max(0, i - k); j <= Math.min(n - 1, i + k); j++) {
                    if (graph[j] == 'H') {
                        cnt++;
                        graph[j] = 'E';
                        break;
                    }
                }
            }

        }
        System.out.println(cnt);
    }
}