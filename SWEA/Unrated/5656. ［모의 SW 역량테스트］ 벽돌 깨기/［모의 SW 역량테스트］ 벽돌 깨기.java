import java.util.*;
import java.io.*;

public class Solution {
	
	static int n,w,h,answer;
	static List<Integer> picks;
	static int[][] graph;
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
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < t+1; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());	// 구슬 쏘는 횟수
			w = Integer.parseInt(st.nextToken());	// width
			h = Integer.parseInt(st.nextToken());	// height
			
			graph = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			answer = Integer.MAX_VALUE;
			
			picks = new ArrayList<>();
			choose(0);
			
			System.out.println("#" + tc + " " + answer);
		}
		
		
	}

	private static void choose(int depth) {
		if (depth == n) {
			
			//개수 확인
//			for (int i = 0; i < picks.size(); i++) {
//				System.out.print(picks.get(i));
//			}
//			System.out.println();
			
			int count = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (graph[i][j] > 0) count++;
//					System.out.print(graph[i][j] + " ");
				}
//				System.out.println();
			}
//			System.out.println();
			
			answer = Math.min(answer, count);
			
			return;
		}
		
		for (int j = 0; j < w; j++) {
			picks.add(j);
			//기존 graph 복사
			int[][] temp = new int[h][w];
			for (int a = 0; a < h; a++) {
				temp[a] = graph[a].clone();
			}
			//내리는 메서드 작성
			Point point = drop(j);
			//내리는 메서드 집어넣기
			bfs(point);
			applyGravity();
			choose(depth+1);
			picks.remove(picks.size()-1);
			graph = temp;
		}
	}
	
	private static void bfs(Point p) {
		if (p.x == -1) return;
		
		Deque<Point> deq = new ArrayDeque<>();
		deq.addLast(p);

		while (!deq.isEmpty()) {
			Point point = deq.pollFirst();
			int range = graph[point.x][point.y];
			graph[point.x][point.y]= 0; 
			
			for (int i = 0; i < 4; i++) {
				int cnt = 0;
				int nx = point.x;
				int ny = point.y;
				while (++cnt < range) {
					nx += dx[i];
					ny += dy[i];
					if (nx < 0 || nx > (h-1) || ny < 0 || ny > (w-1)) break;
					if (graph[nx][ny] > 0) {
						deq.addLast(new Point(nx,ny));
					}
				}
				
				
			}
		}
	}
	
	private static void applyGravity() {
		
		for (int j = 0; j < w; j++) {
			List<Integer> values = new ArrayList<>();
			for (int i = h-1; i > -1; i--) {
				if (graph[i][j] > 0) {
					values.add(graph[i][j]);
				}
			}
			
			int len = values.size();
			int idx = 0;
			for (int i = h-1; i > -1; i--) {
				if (idx < len) {
					graph[i][j] = values.get(idx++);
				} else {
					graph[i][j] = 0;
				}
			}
		}
	}
	
	private static Point drop(int j) {
		for (int i = 0; i < h; i++) {
			if (graph[i][j] != 0) {
				return new Point(i,j);
			}
		}
		
		return new Point(-1,-1);
	}
}
