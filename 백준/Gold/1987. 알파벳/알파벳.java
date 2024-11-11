import java.util.*;
import java.io.*;

public class Main {

	static int r,c,answer;
	static char[][] graph;
	static boolean[] used;
	static boolean[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		graph = new char[r][c];
		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			for (int j = 0; j < c; j++) {
				graph[i][j] = s.charAt(j);
			}
		}
		
		used = new boolean[26];
		visited = new boolean[r][c];
		used[graph[0][0] - 65] = true;
		visited[0][0] = true;
		answer = 1;
		find(0,0,1);
		
		System.out.println(answer);
	}
	
	private static void find(int x, int y, int cnt) {
		answer = Math.max(answer, cnt);
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx > (r-1) || ny < 0 || ny > (c-1)) continue;
			
			char alpha = graph[nx][ny];
			if (!visited[nx][ny] && !used[alpha-65]) {
				used[alpha-65] = true;
				visited[nx][ny] = true;
				find(nx, ny, cnt+1);
				used[alpha-65] = false;
				visited[nx][ny] = false;
			}
		}
	}

}
