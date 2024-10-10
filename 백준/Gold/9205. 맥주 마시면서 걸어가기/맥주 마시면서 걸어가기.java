import java.util.*;
import java.io.*;

public class Main {
	
	static int t,n;
	static Point[] graph;
	static int[][] dist;
	
	static class Point{
		int x;
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		t = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < t; tc++) {
			n = Integer.parseInt(br.readLine());
			
			graph = new Point[n+2];		// 편의점 + 집 + 페스티벌
			for (int i = 0; i < n+2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				graph[i] = new Point(x,y);
			}
			
			dist = new int[n+2][n+2];
			for (int i = 0; i < n+2; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			
			for (int i = 0; i < n+2; i++) {
				for (int j = 0; j < n+2; j++) {
					if (i==j) {
						dist[i][j] = 0;
					} else {
						int d = distance(graph[i], graph[j]);
						if (d <= 1000) {
							dist[i][j] = 1;
						}
					}
				}
			}
			
			// 플로이드 워샬
			for (int k = 0; k < n+2; k++) {
				for (int i = 0; i < n+2; i++) {
					for (int j = 0; j < n+2; j++) {
						if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
							if (dist[i][j] > dist[i][k] + dist[k][j]) {
								dist[i][j] = dist[i][k] + dist[k][j];
							}	
						}
					}
				}
			}
			
			if (dist[0][n+1] != Integer.MAX_VALUE) {
				sb.append("happy\n");
			} else {
				sb.append("sad\n");
			}
		}
		System.out.println(sb.toString());

	}
	
	private static int distance(Point a, Point b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y); 
	}

}
