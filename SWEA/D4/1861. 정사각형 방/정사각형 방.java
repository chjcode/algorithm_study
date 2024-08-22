
import java.util.*;
import java.io.*;

public class Solution {

	static int n,answer,roomNum;
	static int[][] graph;
	static List<Point> lst;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static boolean[][] visited;
	
	static class Point implements Comparable<Point>{
		int x;
		int y;
		int num;
		Point(int x, int y,int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
		@Override
		public int compareTo(Point o) {
			return this.num - o.num;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < t+1; tc++) {
			n = Integer.parseInt(br.readLine());
			graph = new int[n][n];
			lst = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					int temp = Integer.parseInt(st.nextToken());
					graph[i][j] = temp;
					lst.add(new Point(i,j,temp));
				}
			}
			
			Collections.sort(lst);

			visited = new boolean[n][n];
			roomNum = 0;
			answer = 0;
			for (int i = 0; i < n*n; i++) {
				if (!visited[lst.get(i).x][lst.get(i).y]) {
					bfs(lst.get(i));
				}
			}
			
			System.out.println("#" + tc + " " + roomNum + " " + answer);
		}
			
	}
	
	private static void bfs(Point p) {
		Deque<Point> deq = new ArrayDeque<>();
		deq.addLast(p);
		visited[p.x][p.y] = true;
		int num = p.num;
		int cnt = 1;
		while (!deq.isEmpty()) {
			Point point = deq.pollFirst();
			for (int i = 0; i < 4; i++) {
				int nx = point.x + dx[i];
				int ny = point.y + dy[i];
				
				if (nx < 0 || nx > (n-1) || ny < 0 || ny > (n-1)) {
					continue;
				}
				
				if (graph[nx][ny] == graph[point.x][point.y] + 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					deq.addLast(new Point(nx,ny,graph[nx][ny]));
					cnt++;
				}
			}
		}

		if (answer < cnt) {
			roomNum = num;
			answer = cnt;
		}
	}

}
