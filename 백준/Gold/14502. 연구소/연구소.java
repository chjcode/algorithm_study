
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m, maxCnt;
	static int[][] graph;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static class Point{
		int x;
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		maxCnt = 0;
		dfs(0);
		
		System.out.println(maxCnt);
		
	}
	
	private static void dfs(int depth) {
		if (depth == 3) {
			bfs();
			return;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
	
				if (graph[i][j] == 0) {
					graph[i][j] = 1;
					dfs(depth+1);
					graph[i][j] = 0;
				}
			}
		}
		return;
	}
	
	
	private static void bfs() {
		Deque<Point> deq = new ArrayDeque<>();
		
		int[][] tempGraph = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (graph[i][j] == 2) {
					deq.addLast(new Point(i,j));
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			tempGraph[i] = graph[i].clone();
		}
		
		while (!deq.isEmpty()) {
			Point point = deq.poll();
			for (int i = 0; i < 4; i++) {
				int nx = point.x + dx[i];
				int ny = point.y + dy[i];
				
				if (nx < 0 || nx > (n-1) || ny < 0 || ny > (m-1)) {
					continue;
				}
				
				if (tempGraph[nx][ny] == 0) {
					deq.addLast(new Point(nx,ny));
					tempGraph[nx][ny] = 2;
				}
			}
		}
		
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tempGraph[i][j] == 0) {
					count++;
				}
			}
		}
		maxCnt = Math.max(maxCnt, count);
	}

}





