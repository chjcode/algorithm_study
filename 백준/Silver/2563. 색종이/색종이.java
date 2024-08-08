
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] graph = new int[100][100];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			x--;
			y--;
			for (int a = x; a < x + 10; a++) {
				for (int b = y; b < y + 10; b++) {
					graph[a][b] = 1;
				}
			}
		}

		int count = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (graph[i][j] == 1) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
