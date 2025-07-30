import java.util.*;
import java.io.*;

public class Main {
    
    static class Pipe {
        int l;
        int c;
        Pipe(int l, int c) {
            this.l = l;
            this.c = c;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());    // 강과의 거리
        int p = Integer.parseInt(st.nextToken());    //파이프 개수
        
        //수도관을 한 개 만들어 총 길이가 d와 같게 할 때, 가능한 최대 수도관 용량
        // 길이는 d일 때 p의 용량 중 최솟값이 최대가 되도록.
        Pipe[] pipe = new Pipe[p];
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pipe[i] = new Pipe(l,c);
        }
        
        int[] dp = new int[d+1];
        dp[0] = Integer.MAX_VALUE;
        
        for (int i = 0; i < p; i++) {
            int l = pipe[i].l;
            int c = pipe[i].c;
            for (int j = d; j >= l; j--) {
                if (dp[j-l] > 0) {
                    dp[j] = Math.max(dp[j], Math.min(dp[j-l], c));
                }
            }
        }
        
        System.out.println(dp[d]);
        
    }
}