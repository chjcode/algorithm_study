
import java.util.*;
import java.io.*;

public class Solution {
	
	static int n,m,o;
	static char[][] graph;
	static Deque<Character> orders;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static class Tank{
		int x;
		int y;
		int dx;
		int dy;
		
		Tank(int x, int y, int dx, int dy) {
			this.x = x;
			this.y = y;
			this.dx = dx;
			this.dy = dy;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < t+1; tc++) {
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			graph = new char[n][m];
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				for (int j = 0; j < m; j++) {
					graph[i][j] = s.charAt(j);
				}
			}
			
			o = Integer.parseInt(br.readLine());
			orders = new ArrayDeque<>();
			String s = br.readLine();
			for (int i = 0; i < o; i++) {
				orders.addLast(s.charAt(i));
			}
			
			boolean flag = false;
			Tank tank = new Tank(0,0,0,0);
			for(int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (graph[i][j] == '^') {
						flag = true;
						graph[i][j] = '.';
						tank = play(new Tank(i,j,-1,0));
						break;
					} else if (graph[i][j] == 'v') {
						flag = true;
						graph[i][j] = '.';
						tank = play(new Tank(i,j,1,0));
						break;
					} else if (graph[i][j] == '<') {
						flag = true;
						graph[i][j] = '.';
						tank = play(new Tank(i,j,0,-1));
						break;
					} else if (graph[i][j] == '>') {
						flag = true;
						graph[i][j] = '.';
						tank = play(new Tank(i,j,0,1));
						break;
					}
				}
				if (flag) {
					break;
				}
			}
			

			
			int x = tank.x;
			int y = tank.y;
			
			if (tank.dx == -1 && tank.dy == 0) {
				graph[x][y] = '^';
			} else if (tank.dx == 1 && tank.dy == 0) {
				graph[x][y] = 'v';
			} else if (tank.dx == 0 && tank.dy == -1) {
				graph[x][y] = '<';
			} else if (tank.dx == 0 && tank.dy == 1) {
				graph[x][y] = '>';
			}
			
			
			System.out.print("#" + tc + " ");
			for (int i = 0 ; i < n; i++) {
				for (int j = 0; j < m; j++) {
					System.out.print(graph[i][j]);
				}
				System.out.println();
			}
		}
	}
	
	private static Tank play(Tank tank) {
		
		int x = tank.x;
		int y = tank.y;
		int dx = tank.dx;
		int dy = tank.dy;

		while (!orders.isEmpty()) {
			char order = orders.pollFirst();
			if (order == 'U') {
				dx = -1;
				dy = 0;
				int nx = x + dx;
				int ny = y + dy;
				
				if (nx < 0 || graph[nx][ny] == '-' || graph[nx][ny] == '#' || graph[nx][ny] == '*') {

					continue;
				}
				x = nx;
				y = ny;
				

			}
			else if (order == 'D') {
				dx = 1;
				dy = 0;
				int nx = x + dx;
				int ny = y + dy;
				if (nx > (n-1)|| graph[nx][ny] == '-' || graph[nx][ny] == '#' || graph[nx][ny] == '*') {

					continue;
				}
				x = nx;
				y = ny;
				


			}
			else if (order =='L') {
				dx = 0;
				dy = -1;
				int nx = x + dx;
				int ny = y + dy;
				if (ny < 0|| graph[nx][ny] == '-' || graph[nx][ny] == '#' || graph[nx][ny] == '*') {
					
					continue;
				}
				x = nx;
				y = ny;
				

			}
			else if (order == 'R') {
				dx = 0;
				dy = 1;
				int nx = x + dx;
				int ny = y + dy;
				if (ny > (m-1)|| graph[nx][ny] == '-' || graph[nx][ny] == '#' || graph[nx][ny] == '*') {
					continue;
				}
				x = nx;
				y = ny;
			

			}
			else if (order == 'S') {
				// 포탄은 벽돌로 만들어진 벽 또는 강철로 만들어진 벽에 충돌하거나
				// 게임 맵 밖으로 나갈 때 까지 직진한다.
				int tempX = x;
				int tempY = y;
				while (true) {
					int nx = tempX + dx;
					int ny = tempY + dy;
					if (nx < 0 || nx > (n-1) || ny < 0 || ny > (m-1)) {
						break;
					}
					if (graph[nx][ny] == '*') {
						graph[nx][ny] = '.';
						break;
					}
					if (graph[nx][ny] == '#') {
						break;
					}
					tempX = nx;
					tempY = ny;
					
				}
				

			}
		}
		return new Tank(x,y,dx,dy);
	}

}
