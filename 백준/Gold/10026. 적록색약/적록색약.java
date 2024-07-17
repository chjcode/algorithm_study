
import java.util.*;
import java.io.*;

public class Main {
	
	static int n, cntN, cntRG;
	static char[][] graph;
	static boolean[][] visitedN, visitedRG;
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
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		graph = new char[n][n];
		visitedN = new boolean[n][n];
		visitedRG = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				graph[i][j] = s.charAt(j);
				visitedN[i][j] = false;
				visitedRG[i][j] = false;
			}
		}
		
		cntN = 0;
		cntRG = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visitedN[i][j]) {
					bfs_n(i,j,graph[i][j]);
					cntN += 1;
				}
				if (!visitedRG[i][j]) {
					bfs_rg(i,j,graph[i][j]);
					cntRG += 1;
				}
			}
		}
		
		System.out.println(cntN + " " + cntRG);

	}
	
	public static void bfs_n(int x, int y, char color) {
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(x,y));
		
		while (!que.isEmpty()) {
			Point point = que.poll();
			for (int i = 0; i < 4; i++) {
				int nx = point.x + dx[i];
				int ny = point.y + dy[i];
				if (nx < 0 || nx > (n-1) || ny < 0 || ny > (n-1)) {
					continue;
				}
				if (!visitedN[nx][ny] && graph[nx][ny] == color) {
					visitedN[nx][ny] = true;
					que.add(new Point(nx,ny));
				}
			}
		}
	}
	
	public static void bfs_rg(int x, int y, char color) {
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(x,y));
		
		while (!que.isEmpty()) {
			Point point = que.poll();
			for (int i = 0; i < 4; i++) {
				int nx = point.x + dx[i];
				int ny = point.y + dy[i];
				if (nx < 0 || nx > (n-1) || ny < 0 || ny > (n-1)) {
					continue;
				}
				if ((color == 'R' || color == 'G') && !visitedRG[nx][ny]) {
					if (graph[nx][ny] == 'R' || graph[nx][ny] == 'G') {
						visitedRG[nx][ny] = true;
						que.add(new Point(nx,ny));
					}
				} else {
					if (!visitedRG[nx][ny] && graph[nx][ny] == color) {
						visitedRG[nx][ny] = true;
						que.add(new Point(nx,ny));
					}
				}
			}
		}
	}
}











