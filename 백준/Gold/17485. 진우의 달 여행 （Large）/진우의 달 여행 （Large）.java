import java.util.*;
import java.io.*;

public class Main {
    
    static int n,m,answer;
    static int[][] graph;
    static int[][][] dp;
    static int[] dy = {-1, 0, 1};

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        // 그래프 초기화
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < m; j++) {
        		graph[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        // dp 최대값으로 초기화
        dp = new int[3][n][m];
        for (int d = 0; d < 3; d++) {
        	for (int i = 0; i < n; i++) {
        		Arrays.fill(dp[d][i],Integer.MAX_VALUE);
        	}
        }
        // dp 첫 줄 초기화
        for (int d = 0; d < 3; d++) {
        	for (int j = 0; j < m; j++) {
        		dp[d][0][j] = graph[0][j];
        	}
        }
        
        //dp 탐색 시작
        //dp의 각 cell에는 거쳐온 경로들의 합이 누적되어 있음
        for (int i = 0; i < n-1; i++) {		// 마지막 줄은 탐색 x
        	for (int j = 0; j < m; j++) {
        		for (int d = 0; d < 3; d++) {
        			if (dp[d][i][j] == Integer.MAX_VALUE) continue;
        			
        			for (int dir = 0; dir < 3; dir++) {
        				if (dir == d) continue;	// k방향으로 연속해서 갈 수 없으므로
        				int ny = j + dy[dir];
        				if (ny < 0 || ny > (m-1)) continue;
        				dp[dir][i+1][ny] = Math.min(dp[dir][i+1][ny], dp[d][i][j]+graph[i+1][ny]);
        			}
        		}
        	}
        }
        
        answer = Integer.MAX_VALUE;
        for (int d = 0; d < 3; d++) {
        	for (int j = 0; j < m; j++) {
            	answer = Math.min(answer, dp[d][n-1][j]);
            }	
        }
        
        System.out.println(answer);
    }
}
