
import java.util.*;
import java.io.*;

public class Solution {
	
	static int n,m,r,c,l;
	static int[][] graph;
	static int[][] visited;
	static int[][][] pipe = {{},
			{{0,1},{0,-1},{1,0},{-1,0}},
			{{1,0},{-1,0}},
			{{0,1},{0,-1}},
			{{-1,0},{0,1}},
			{{1,0},{0,1}},
			{{0,-1},{1,0}},
			{{0,-1},{-1,0}}};
	
	static class Point{
		int x,y,type;
		Point(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < t+1; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());	// n,m : 그래프 크기
			m = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());	// r,c : 맨홀 뚜껑 위치
			c = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());	// 탈출 후 소요된 시간
			
			graph = new int[n][m];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			visited = new int[n][m];
			System.out.println("#" + tc + " " + bfs(r,c));
			
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < m; j++) {
//					System.out.print(visited[i][j] + " ");
//				}
//				System.out.println();
//			}
//			
		}
	}
	
	private static int bfs(int x, int y) {
		Deque<Point> deq = new ArrayDeque<>();
		deq.addLast(new Point(x,y,graph[x][y]));
		visited[x][y] = 1;
		int cnt = 1;
		
		while (!deq.isEmpty()) {
			Point point = deq.pollFirst();
			
			if (visited[point.x][point.y] == l) continue;
			
			for (int i = 0; i < pipe[point.type].length; i++) {
				int nx = point.x + pipe[point.type][i][0];
				int ny = point.y + pipe[point.type][i][1];
				
				if (nx < 0 || nx > (n-1) || ny < 0 || ny > (m-1)) {	// 범위 밖으로 나간 경우
					continue;
				}
				
				if (graph[nx][ny] == 0) continue;	// 파이프가 아닌 경우
				
				// 연결된 파이프가 아닐 경우
				if (!isConnected(pipe[point.type][i],nx,ny)) continue;
//				boolean flag = false;
//				for (int a = 0; a < pipe[graph[nx][ny]].length; a++) {
//					if (pipe[point.type][i][0] == pipe[graph[nx][ny]][a][0] && pipe[point.type][i][1] == pipe[graph[nx][ny]][a][1]) {
//						flag = true;
//						break;
//					}
//
//					if (flag) break;
//				}
//				
//				if (!flag) continue;
				

				
				if (visited[nx][ny] == 0) {
					visited[nx][ny] = visited[point.x][point.y] + 1;
					cnt++;
					deq.addLast(new Point(nx,ny,graph[nx][ny]));
				}
			}
		}
		return cnt;
		
	}
	
	// 다음 pipe의 type을 for문으로 돌면서 현재 방향에 (-)를 취한 값이 있는지를 판단
	private static boolean isConnected(int[] direction, int nx, int ny) {
		for (int[] dir : pipe[graph[nx][ny]]) {
			if (dir[0] == -direction[0] && dir[1] == -direction[1]) {
				return true;
			}
		}
		return false;
	}
}


//5
//5 6 2 1 3
//0 0 5 3 6 0
//0 0 2 0 2 0
//3 3 1 3 7 0
//0 0 0 0 0 0
//0 0 0 0 0 0
