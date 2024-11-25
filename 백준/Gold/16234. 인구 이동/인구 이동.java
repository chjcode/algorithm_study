import java.util.*;
import java.io.*;

public class Main {

	static int n,l,r;
	static boolean flag,unioned;
	static int[][] graph;
	static boolean[][] visited;
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
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		graph = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int day = 0;
		flag = true;
		while (flag) {
			flag = false;
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j]) {
						unioned = false;
						bfs(i,j);
					}
				}
			}
			
			if (flag) day++;
		}
		
		System.out.println(day);
	}
	
	private static void bfs(int x, int y) {
		Deque<Point> union = new ArrayDeque<>();
		Deque<Point> deq = new ArrayDeque<>();
		deq.addLast(new Point(x,y));
		union.addLast(new Point(x,y));
		visited[x][y] = true;
		int cnt = graph[x][y];
		int unionSize = 1;
		while(!deq.isEmpty()) {
			Point point = deq.pollFirst();
			//union이 일어났는지는 어떻게알지"? flag를 하나 둬야하나?
			for (int i = 0; i < 4; i++) {
				int nx = point.x + dx[i];
				int ny = point.y + dy[i];
				
				if (nx < 0 || nx > (n-1) || ny < 0 || ny > (n-1)) continue;
				
				int diff = Math.abs(graph[nx][ny] - graph[point.x][point.y]);
				if (l <= diff && diff <= r && !visited[nx][ny]) {
					cnt += graph[nx][ny];
					unionSize++;
					union.addLast(new Point(nx,ny));
					deq.addLast(new Point(nx,ny));
					visited[nx][ny] = true;
					flag = true;
					unioned = true;
				}
			}
		}
		
		if (unioned) {
			int population = cnt / unionSize;
			while (!union.isEmpty()) {
				Point point = union.pollFirst();
				graph[point.x][point.y] = population;
			}
		}
	}
	

}
