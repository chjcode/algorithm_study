
import java.util.*;
import java.io.*;

public class Solution {
	static int n,answer;
	static int[][] graph, temp;
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
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < t+1; tc++) {
			
			
			n = Integer.parseInt(br.readLine());
			graph = new int[n][n];
			
			for (int i = 0 ; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			answer = 0;
			for (int day = 0; day <= 100; day++) {
				for (int i = 0; i< n; i++) {
					for (int j = 0; j < n; j++) {
						if (graph[i][j] == day) {
							graph[i][j] = 0;
						}
					}
				}
				
				int cnt = 0;
				temp = new int[n][n];
				for (int i = 0; i < n; i++) {
					temp[i] = graph[i].clone();
				}
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (temp[i][j] != 0) {
							bfs(i,j);
							cnt++;
						}
					}
				}
				
				answer = Math.max(answer, cnt);
				
			}
			
			
			System.out.println("#" +tc + " "+answer);
			
		}
		
	}
	
	private static void bfs(int x, int y) {
		Deque<Point> deq = new ArrayDeque<>();
		deq.addLast(new Point(x,y));
		temp[x][y] = 0;
		while (!deq.isEmpty()) {
			Point point= deq.pollFirst();
			for (int i = 0; i < 4; i++) {
				int nx = point.x + dx[i];
				int ny = point.y + dy[i];
				if (nx < 0 || nx > (n-1) || ny < 0 || ny > (n-1)) {
					continue;
				}
				
				if (temp[nx][ny] > 0) {
					temp[nx][ny] = 0;
					deq.addLast(new Point(nx,ny));
				}
			}
		}
	}

}
