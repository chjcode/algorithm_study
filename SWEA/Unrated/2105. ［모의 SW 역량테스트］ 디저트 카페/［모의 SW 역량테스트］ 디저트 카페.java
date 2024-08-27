
import java.util.*;
import java.io.*;

public class Solution {
	
	static int n,answer;
	static int[][] graph;
	static boolean[] visited;
	static int[] dx = {1,1,-1,-1};
	static int[] dy = {1,-1,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 같은 숫자 만나면 break; -> 같은 숫자 여부 visit배열로 판단
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < t+1; tc++) {
			n = Integer.parseInt(br.readLine());
			
			graph = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < n; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 중복 탐색 어떻게 방지할 것?
			answer = -1;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					visited = new boolean[101];
					dfs(i,j,i,j,0,0);
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}

	}
	
	private static void dfs(int x, int y, int endX, int endY, int idx, int cnt) {

		if (x == endX && y == endY && idx == 3) {
			answer = Math.max(answer, cnt);
			return;
		}
		
		if (x < 0 || x > (n-1) || y < 0 || y > (n-1)) {
			return;
		}
		
		// 이미 같은 숫자의 디저트를 파는 카페를 방문한 적이 있으면 return
		if (visited[graph[x][y]]) {
			return;
		}
		visited[graph[x][y]] = true;
		dfs(x+dx[idx],y+dy[idx], endX,endY,idx,cnt+1);
		if (idx < 3) {
			dfs(x+dx[idx+1], y+dy[idx+1], endX,endY,idx+1,cnt+1);	
		}
		visited[graph[x][y]] = false;
		
	}
}