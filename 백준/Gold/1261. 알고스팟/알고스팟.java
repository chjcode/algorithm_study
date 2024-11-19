import java.util.*;
import java.io.*;

public class Main {

	static int n,m;
//	static List<List<Node>> graph;
	static int[][] graph;
	static int[][] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int cost;
		Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		graph = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				graph[i][j] = s.charAt(j) - '0';
			}
		}
		
		visited = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}
		bfs(0,0);
		
	}
	
	private static void bfs(int x, int y) {
		PriorityQueue<Node> deq = new PriorityQueue<>();
		deq.add(new Node(x,y,0));
		visited[x][y] = 0;
		
		while(!deq.isEmpty()) {
			Node now = deq.poll();
			
			if (now.x == (n-1) && now.y == (m-1)) {
				System.out.println(now.cost);
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if (nx < 0 || nx > (n-1) || ny < 0 || ny > (m-1)) continue;
				
				if (graph[nx][ny] == 1 && visited[nx][ny] > now.cost+1) {
					deq.add(new Node(nx,ny,now.cost+1));
					visited[nx][ny] = now.cost+1;
				} else if (graph[nx][ny] == 0 && visited[nx][ny] > now.cost){
					deq.add(new Node(nx,ny,now.cost));
					visited[nx][ny] = now.cost;
				}
			}
		}
	}

}
