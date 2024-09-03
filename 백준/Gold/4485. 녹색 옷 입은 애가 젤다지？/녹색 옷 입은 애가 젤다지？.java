import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int[][] graph, visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static class Point implements Comparable<Point> {
		int x, y, cost;

		Point(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point p) {
			return Integer.compare(this.cost, p.cost);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int idx = 1;
		while (true) {

			n = Integer.parseInt(br.readLine());

			if (n == 0) {
				break;
			}

			graph = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			System.out.print("Problem " + idx + ": " + bfs(0, 0) + "\n");
			idx++;
			
		}

	}

	private static int bfs(int x, int y) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(x, y, graph[x][y]));
		
		visited = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(visited[i],Integer.MAX_VALUE);
		}
		visited[x][y] = graph[x][y];

		while (!pq.isEmpty()) {
			Point point = pq.poll();

			if (point.x == n - 1 && point.y == n - 1) {
				return point.cost;
			}

			for (int i = 0; i < 4; i++) {
				int nx = point.x + dx[i];
				int ny = point.y + dy[i];
				
				if (nx < 0 || nx > (n - 1) || ny < 0 || ny > (n - 1)) continue;
				
				if (point.cost + graph[nx][ny] < visited[nx][ny]) {
					visited[nx][ny] = point.cost + graph[nx][ny];
					pq.add(new Point(nx,ny,visited[nx][ny]));
				}
			}
		}
		
		return 0;

	}
}
