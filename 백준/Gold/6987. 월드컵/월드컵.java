
import java.util.*;
import java.io.*;

public class Main {
    
    static int answer;
    static int[][] graph;
    static int[] matchLeft = {0,0,0,0,0, 1, 1, 1,1, 2, 2, 2, 3, 3, 4};
    static int[] matchRight ={1,2,3,4,5, 2, 3, 4,5, 3, 4, 5, 4, 5, 5};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for (int tc = 0; tc < 4; tc++) {
            graph = new int[6][3];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            answer = 0;
            dfs(0);
            System.out.print(answer + " ");
        }
    }
    
    private static void dfs(int cnt) {
        if (cnt == 15) {
            if (check()) {
            	answer = 1;
            }
            return;
        }
        
        int left = matchLeft[cnt];
        int right = matchRight[cnt];
        
        // 왼쪽 나라가 이긴 경우
        if (graph[left][0] > 0 && graph[right][2] > 0) {
            graph[left][0]--;
            graph[right][2]--;
            dfs(cnt + 1);
            graph[left][0]++;
            graph[right][2]++;
        }
        
        // 오른쪽 나라가 이긴 경우
        if (graph[right][0] > 0 && graph[left][2] > 0) {
            graph[right][0]--;
            graph[left][2]--;
            dfs(cnt + 1);
            graph[right][0]++;
            graph[left][2]++;
        }
        
        // 비긴 경우
        if (graph[left][1] > 0 && graph[right][1] > 0) {
            graph[left][1]--;
            graph[right][1]--;
            dfs(cnt + 1);
            graph[left][1]++;
            graph[right][1]++;
        }
    }
    
    private static boolean check() {
    	for (int i = 0; i < 6; i++) {
    		for (int j = 0; j < 3; j++) {
    			if (graph[i][j] != 0) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
}
