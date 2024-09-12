
import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M, shark[], eatNum;
	static int[][] space, moves = {{-1,0},{0,-1},{0,1},{1,0}}; // 상좌우하
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		space = new int[N][N];
		shark = new int[4]; // x, y, size, move
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				int input = Integer.parseInt(st.nextToken());
				if(input == 9) {
					shark[0] = i; shark[1] = j;
				} else if(input != 0) {
					space[i][j] = input;
				}
			}
		}
		shark[2] = 2;
		eatNum = 0;
		
		while(true) {
			if(bfs(shark[0], shark[1], shark[2], shark[3])) {
				space[shark[0]][shark[1]] = 0;
				if(++eatNum == shark[2]) {
					shark[2]++; // 사이즈 업
					eatNum = 0;
				}
			} else break;
		}
		System.out.print(shark[3]);
	}
	
	// bfs로 가장 가까운 물고기 찾기
	static boolean bfs(int x, int y, int size, int move) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y, size, move});
		visited = new boolean[N][N];
		visited[x][y] = true; 
		ArrayList<int[]> result = new ArrayList<>();
		int distance = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int fish = space[now[0]][now[1]];
			
			if(distance < now[3]) break;
			if(fish != 0 && fish < now[2]) {
				// 먹을 수 있는 물고기 찾음.
				result.add(now);
				distance = now[3];
				continue;
			}
			
			for(int[] m : moves) {
				int nx = m[0] + now[0];
				int ny = m[1] + now[1];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				if(space[nx][ny] > now[2]) continue;
				if(visited[nx][ny]) continue;
				visited[nx][ny] = true;
				q.offer(new int[] {nx, ny, now[2], now[3]+1});
			}
		}
		if(result.isEmpty()) return false;
		else {
			Collections.sort(result, (o1, o2) -> o1[0] == o2[0] ? Integer.compare(o1[1], o2[1]) : Integer.compare(o1[0], o2[0]) );
			shark = Arrays.copyOf(result.get(0), 4);
			return true;
		}
	}
}