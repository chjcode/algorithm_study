import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 학생 수
        int k = Integer.parseInt(st.nextToken()); // 졸고 있는 학생 수
        int q = Integer.parseInt(st.nextToken()); // 코드 보낼 학생 수
        int m = Integer.parseInt(st.nextToken()); // 구간 수
        
        boolean[] sleep = new boolean[n+3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int idx = Integer.parseInt(st.nextToken());
            sleep[idx] = true;
        }
        
        int[] start = new int[q];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            start[i] = Integer.parseInt(st.nextToken());
        }
        
        boolean[] answer = new boolean[n+3];
        for (int s : start) {
            if (sleep[s]) continue;
            
            for (int i = s; i <= n + 2; i += s) {
                if (!sleep[i]) {
                    answer[i] = true;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < m; t++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int cnt = 0;
            for (int i = s; i <= e; i++) {
                if (!answer[i]) cnt++;
            }
            sb.append(cnt).append('\n');
        }

        System.out.print(sb.toString());
        
    }
}