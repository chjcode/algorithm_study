import java.util.*;
import java.io.*;

public class Main {
    
    static int n,m,h;
    static boolean[][] ladder; 
    

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        
        ladder = new boolean[h+1][n+1];
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            ladder[a][b] = true;
        }
        
        // 하나 삽입할 때마다 관계있는 라인은 죄다 다시 조회 해야하는데 시간 되나
        int answer = -1;
        for (int i = 0; i <= 3; i++) {
            if (dfs(0,i,1,1)) {
                answer = i;
                break;
            }
        }
        
        System.out.println(answer);
    }
    
    private static boolean dfs(int depth, int rCnt, int x, int y) {
        if (depth == rCnt) {
            // 세로선 검사
            for (int i = 1; i < n+1; i++) {
                // i번 세로선에서 시작
                int now = i;
                // 아래로 내려가기 시작
                for (int j = 1; j < h+1; j++) {
                    // 가로줄 오른쪽에 있으면 오른쪽으로 이동
                    if (ladder[j][now]) {
                        now++;
                    } 
                    // 가로줄 왼쪽에 있으면 왼쪽으로 이동
                    else if (now > 1 && ladder[j][now - 1]) {
                        now--;
                    }
                }
                
                // 제자리로 못돌아오면 실패
                if (now != i) {
                    return false;
                }
            }
            return true;
        }
        
        for (int i = x; i < h+1; i++) {
            int jStart;
            if (i == x) {
                jStart = y;
            } else {
                jStart = 1;
            }
            
            for (int j  = jStart; j < n; j++) {
                if (ladder[i][j] || ladder[i][j-1] || ladder[i][j+1]) {
                    continue;
                }
                
                ladder[i][j] = true;
                
                if (dfs(depth + 1, rCnt, i,j)) {
                    return true;
                }
                
                ladder[i][j] = false;
            }
        }
        return false;
    }
}