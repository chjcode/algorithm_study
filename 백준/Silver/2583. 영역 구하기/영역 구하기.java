
import java.util.*;
import java.io.*;
/**
 * 1. 그래프 입력 받기
 * 2. 직사각형 입력 받기
 * 3. 빈 공간 bfs돌리기 -> 빈 공간 개수, 각 영역의 넓이 출력
 */
public class Main {
	
	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static int m,n,k, mL, nL, mR, nR, cnt;
	static int[][] graph;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		cnt = 0;
		graph = new int[n][m];
		
		for (int a = 0; a < k; a++) {
			st = new StringTokenizer(br.readLine());
			mL = Integer.parseInt(st.nextToken());
			nL = Integer.parseInt(st.nextToken());
			mR = Integer.parseInt(st.nextToken());
			nR = Integer.parseInt(st.nextToken());
			
			for (int i = nL; i < nR;i++) {
				for (int j = mL; j < mR; j++) {
					graph[i][j] = 1;
				}
			}
		}
		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(graph[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		
		List<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (graph[i][j] == 0) {
					arr.add(bfs(i,j));
					cnt += 1;
				}
			}
		}
		Collections.sort(arr);
		
		System.out.println(cnt);
		for (int num : arr) {
			System.out.print(num + " ");
		}
		
	}
	
	static int bfs(int x, int y) {
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(x,y));
		graph[x][y] = 1;
		
		int cnt = 1;
		while (!que.isEmpty()) {
			Point point = que.poll();
			for (int i = 0; i < 4; i++) {
				int nx = point.x + dx[i];
				int ny = point.y + dy[i];
				if (nx < 0 || nx > (n-1) || ny < 0 || ny > (m-1)) {
					continue;
				}
				if (graph[nx][ny] == 0) {
					graph[nx][ny] = 1;
					cnt += 1;
					que.add(new Point(nx,ny));
				}
			}
		}
		
		return cnt;
	}

}
