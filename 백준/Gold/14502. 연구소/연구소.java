
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m, maxCnt,safeAreaCnt;
	static int[][] graph;
	static Deque<Point> virus;
	static List<Point> empty;
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
		
		// 바이러스 위치 저장, 안전 영역 개수 저장
		virus = new ArrayDeque<>();
		empty = new ArrayList<>();
		safeAreaCnt = -3;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (graph[i][j] == 0) {
					safeAreaCnt++;
					empty.add(new Point(i,j));
				}
				if (graph[i][j] == 2) {
					virus.addLast(new Point(i,j));
				}
			}
		}
		
		
		maxCnt = 0;
		dfs(0,0);
		
		System.out.println(maxCnt);
		
	}
	
	private static void dfs(int depth, int start) {
		if (depth == 3) {
			bfs();
			return;
		}
		
		for (int i = start; i < empty.size(); i++) {
			Point point = empty.get(i);
			graph[point.x][point.y] = 1;
			dfs(depth+1, i+1);
			graph[point.x][point.y]= 0; 
		}
		
		return;
	}
	
	
	private static void bfs() {
		Deque<Point> deq = new ArrayDeque<>(virus);
		
		int[][] tempGraph = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			tempGraph[i] = graph[i].clone();
		}
		
		int virusAreaCnt = 0;
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
					virusAreaCnt++;
				}
			}
		}
		maxCnt = Math.max(maxCnt, safeAreaCnt-virusAreaCnt);
	}

}





