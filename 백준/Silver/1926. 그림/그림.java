
import java.util.*;
import java.io.*;

public class Main {
	static int n,m,answer,cnt;
	static int[][] graph;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	public static class XY{
		int x;
		int y;
		
		public XY(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new int[n][m];
		answer = 0;
		cnt = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (graph[i][j] == 1) {
					answer = Math.max(answer, bfs(i,j));
					cnt += 1;
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(answer);
	}
	
	public static int bfs(int a, int b) {
		Queue<XY> q = new LinkedList<>();
		q.add(new XY(a,b));
		
		graph[a][b] = 2;
		int area = 1;
		while (!q.isEmpty()) {
			XY xy = q.remove();  
			for (int i = 0; i < 4; i++) {
				int nx = xy.x + dx[i];
				int ny = xy.y + dy[i];
				if (nx < 0 || nx > (n-1) || ny < 0 || ny > (m-1)) {
					continue;
				}
				if (graph[nx][ny] == 1) {
					graph[nx][ny] = 0;
					area += 1;
					q.add(new XY(nx,ny));
				}
			}	
		}
		return area;
	}
}
