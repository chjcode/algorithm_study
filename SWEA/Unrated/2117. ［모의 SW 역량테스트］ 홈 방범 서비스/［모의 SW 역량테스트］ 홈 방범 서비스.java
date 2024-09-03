
import java.util.*;
import java.io.*;

public class Solution {
	
	static int n,m,house;
	static int[][] graph;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static class Point{
		int x,y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < t+1; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			graph = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			house = 0;
			for (int area = 1; area < n+3; area++) {
				for(int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						bfs(i,j,area);
					}
				}
			}

			
			
			
			System.out.println("#" + tc + " " + house);
			
		}
		
	}
	
	private static void bfs(int x, int y, int area) {
		Deque<Point> deq = new ArrayDeque<>();
		deq.addLast(new Point(x,y));
		
		int[][] visited = new int[n][n];
		visited[x][y] = 1;
		
		int count = 0;
		if (graph[x][y] == 1) {
			count++;
		}
		
		while (!deq.isEmpty()) {
			Point point = deq.pollFirst();
			
			if (visited[point.x][point.y] == area) continue;
			
			for (int i = 0; i < 4; i++) {
				int nx = point.x + dx[i];
				int ny = point.y + dy[i];
				
				if (nx < 0 || nx > (n-1) || ny < 0 || ny > (n-1)) continue;
				
				if (visited[nx][ny] == 0) {
					if (graph[nx][ny] == 1) {
						count++;
					}
					visited[nx][ny] = visited[point.x][point.y] + 1;
					deq.addLast(new Point(nx,ny));
				}
			}
		}
		
		
		if (m*count >= area*area+(area-1) *(area-1)) {
			house = Math.max(house, count);
		}
	}
}
