import java.util.*;
import java.io.*;

public class Main {
    
    static int n, cnt;
    static int[] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = 10;
         arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        cnt = 0;
        dfs(0, 0, 0, 0);
        
        System.out.println(cnt);
        
    }
    private static void dfs(int depth, int score, int last, int same) {
        if (depth == 10) {
            if (score >= 5) cnt++;
            return;
        }
        
        for (int i = 1; i <= 5; i++) {
            
            // 세번 연속 같은 답은 패스
            if (i == last && same == 2) continue;
            
            int tempScore = score;
            int tempSame = 1;
            
            // 현재 선택한 답(i)가 정답이면 1점 추가
            if (i == arr[depth]) {
                tempScore++;
            }
            
            // 현재 선택한 답(i)가 이전 답이랑 같으면 연속 횟수 1 증가
            if (i == last) {
                tempSame++;
            }
            
            dfs(depth+1, tempScore, i, tempSame);
        }
        
    }
}