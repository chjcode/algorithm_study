
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Point{
		int x;
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int n,cnt;
	static int[][] graph;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static List<Integer> answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		graph = new int[n][n];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				graph[i][j] = s.charAt(j)-'0';
			}
		}
		
		answer = new ArrayList<>();
		cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (graph[i][j] == 1) {
					bfs(i,j);
					cnt += 1;
				}
			}
		}
		
		System.out.println(cnt);
		Collections.sort(answer);
		for (Integer num :answer) {
			System.out.println(num);
		}
		
	}
	
	public static void bfs(int x, int y) {
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(x,y));
		graph[x][y] = 0;
		int count = 1;
		while (!que.isEmpty()) {
			Point point = que.poll();
			for (int i = 0; i < 4; i++) {
				int nx = point.x + dx[i];
				int ny = point.y + dy[i];
				if (nx < 0 || nx > (n-1) || ny < 0 || ny > (n-1)) {
					continue;
				}
				
				if (graph[nx][ny] == 1) {
					graph[nx][ny] = 0;
					count += 1;
					que.add(new Point(nx,ny));
				}
				
			}
		}
		
		answer.add(count);
	}
}
