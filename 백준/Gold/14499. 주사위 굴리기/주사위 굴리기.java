
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m, x, y, k, move;
	static int[][] graph;
	static int[] dice;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		graph = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 주사위 세팅
		dice = new int[6];

		// 주사위 굴리기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			int move = Integer.parseInt(st.nextToken());
			move--;
			int nx = x + dx[move];
			int ny = y + dy[move];

			if (nx < 0 || nx > (n - 1) || ny < 0 || ny > (m - 1)) {
				continue;
			}

			rollDice(move);

			if (graph[nx][ny] == 0) {
				graph[nx][ny] = dice[5];
			} else {
				dice[5] = graph[nx][ny];
				graph[nx][ny] = 0;
			}

			System.out.println(dice[0]);

			x = nx;
			y = ny;

		}

	}

	private static void rollDice(int move) {
		if (move == 0) {
			int temp = dice[2];
			dice[2] = dice[0];
			dice[0] = dice[3];
			dice[3] = dice[5];
			dice[5] = temp;
		} else if (move == 1) {
			int temp = dice[3];
			dice[3] = dice[0];
			dice[0] = dice[2];
			dice[2] = dice[5];
			dice[5] = temp;
			
		} else if (move == 2) {
			int temp = dice[5];
			dice[5] = dice[4];
			dice[4] = dice[0];
			dice[0] = dice[1];
			dice[1] = temp;
		} else if (move == 3) {
			int temp = dice[1];
			dice[1] = dice[0];
			dice[0] = dice[4];
			dice[4] = dice[5];
			dice[5] = temp;
		}
	}

}
