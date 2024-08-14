
import java.util.*;
import java.io.*;

public class Main {
	
	static int n,m,answer;
	static int cctvCnt;
	static int[][] graph;
	static List<CCTV> lst,type5Lst;
	static int[] dx = {0,0,1,-1};	//동,서,남,북
	static int[] dy = {1,-1,0,0};
	static int[][][] mode = {
			{{0},{1},{2},{3}},
			{{0,1},{2,3}},
			{{0,3},{0,2},{1,2},{1,3}},
			{{1,2,3},{0,2,3},{0,1,3},{0,1,2}}};
	
	static class CCTV {
		int x;
		int y;
		int type;
		
		CCTV(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new int[n][m];
		lst = new ArrayList<>();
		type5Lst = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int temp = Integer.parseInt(st.nextToken());
				graph[i][j] = temp;
				if (graph[i][j] >= 1 && graph[i][j] <=4) {
					lst.add(new CCTV(i,j,temp));
				}else if (graph[i][j] == 5) {
					type5Lst.add(new CCTV(i,j,temp));
				}
			}
		}
		
		// cctv type 5는 미리 적용
		for (CCTV cctv : type5Lst) {
			for (int k = 0; k < 4; k++) {
				int nx = cctv.x + dx[k];
				int ny = cctv.y + dy[k];
				
				while (true) {
					if (nx < 0 || nx > (n-1) || ny < 0 || ny > (m-1) || graph[nx][ny] == 6) {
						break;
					}
					if (graph[nx][ny] == 0) {
						graph[nx][ny] = -1;
					}
					nx += dx[k];
					ny += dy[k];
				}
			}
		}
		
		// combination
		cctvCnt = lst.size();
		answer = Integer.MAX_VALUE;
		simulate(0,graph);
		System.out.println(answer);
		
		
	}
	
	private static void simulate(int depth, int[][] graph) {
		if (depth == cctvCnt) {
			int zeroCnt = countZero(graph);
			answer = Math.min(answer,zeroCnt);
			return;
		}
		
		int cctvType = lst.get(depth).type-1;
		int x = lst.get(depth).x;
		int y = lst.get(depth).y;
		
		for (int i = 0; i < mode[cctvType].length; i++) {	//cctv
			int[][] graphCopy = new int[n][m];
			for( int k = 0; k < n; k++) { 
				for (int l =0; l < m; l++)
				graphCopy[k][l] = graph[k][l];
			}
			
			for (int j = 0; j < mode[cctvType][i].length; j++) {
				int dir = mode[cctvType][i][j];
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				while (true) {
					if (nx < 0 || nx > (n-1) || ny < 0 || ny > (m-1) || graph[nx][ny] == 6) {
						break;
					}
					
					graphCopy[nx][ny] = -1;
					nx += dx[dir];
					ny += dy[dir];
				}
			}
			simulate(depth+1, graphCopy);
		}
	}
	
	private static int countZero(int[][] graph) {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (graph[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

}
