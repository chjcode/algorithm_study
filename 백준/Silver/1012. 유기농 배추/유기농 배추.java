
import java.util.*;
import java.io.*;

public class Main {
	static int n, m, k, t, cnt;
	static int[][] graph;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	public static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		t = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			graph = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					graph[i][j] = 0;
				}
			}
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				graph[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
				
			}
			
			cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (graph[i][j] == 1) {
						bfs(i,j);
						cnt += 1;
					}
				}
			}
			System.out.println(cnt);
		}
	}
	
	public static void bfs(int a, int b) {
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(a,b));
		
		while(!que.isEmpty()) {
			Point point = que.poll();
			
			for (int i = 0; i <4; i++) {
				int nx = point.x + dx[i];
				int ny = point.y + dy[i];
				
				if (nx < 0 || nx > (n-1) || ny < 0 || ny > (m-1)) {
					continue;
				}
				
				if (graph[nx][ny] == 1) {
					graph[nx][ny] = 0;
					que.add(new Point(nx,ny));
				}
			}
			
		}
		
	}
}
