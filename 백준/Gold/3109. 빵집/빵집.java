
import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m, cnt;
	static char[][] graph;
	static int[] dx = {-1,0,1};
	static int[] dy = {1,1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new char[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				graph[i][j] = s.charAt(j);
			}
		}

		cnt = 0;
		for (int i = 0; i < n; i++) {
			if (dfs(i,0)) {
				cnt++;
			}
		}
		System.out.println(cnt);

	}
	
	private static boolean dfs(int x, int y) {
		graph[x][y] = 'X';
		
		if (y == m-1) {
			return true;
		}
		
		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || nx > (n-1) || ny < 0 || ny > (m-1)) {
				continue;
			}
			
			if (graph[nx][ny] == '.') {
				if (dfs(nx,ny)) {
					return true;
				}
			}
		}
		return false;
		
	}

}
