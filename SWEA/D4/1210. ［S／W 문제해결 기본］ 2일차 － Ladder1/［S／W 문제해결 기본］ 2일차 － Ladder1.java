
import java.io.*;
import java.util.*;

public class Solution {
	
	static int t,n,answer;
	static int[][] graph;
	static int[] dx = {0,0,-1};
	static int[] dy = {1,-1,0};
	
	static class Point{
		int x;
		int y;
		Point (int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 0; t < 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			graph = new int[100][100];
			n = 100;
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			answer = 0;
			for (int j = 0; j < n; j++) {
				if (graph[n-1][j] == 2) {
					find(n-1,j);
					break;
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
		
	}
	
	private static void find(int a, int b) {
		Deque<Point> deq = new ArrayDeque<>();
		deq.addLast(new Point(a,b));
		
		while (!deq.isEmpty()) {
			Point point = deq.pollFirst();
			
			if (point.x == 0) {
				answer =  point.y;
			}
			
			// 좌우 확인
			boolean flag = false;
			for (int i = 0; i < 3; i++) {
				int nx = point.x + dx[i];
				int ny = point.y + dy[i];
				
				if (nx < 0 || nx > (n-1) || ny < 0 || ny > (n-1)) {
					continue;
				}
				if (graph[nx][ny] == 1) {
					graph[nx][ny] = 2;
					deq.addLast(new Point(nx,ny));
					break;
				}
				
			}
		}
	}

}
