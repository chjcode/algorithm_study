import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[] graph = new char[n];
        String s = br.readLine();
        for (int i = 0; i < n; i++) {
            graph[i] = s.charAt(i);
        }

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