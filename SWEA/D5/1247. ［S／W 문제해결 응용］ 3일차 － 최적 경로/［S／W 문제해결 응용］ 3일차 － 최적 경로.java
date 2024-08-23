
import java.util.*;
import java.io.*;

public class Solution {

	static int n, answer;
	static Point[] customers;
	static boolean[] visited;
	static Point company, house;

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < t + 1; tc++) {
			n = Integer.parseInt(br.readLine());
			// n 명의 고객을 모두 방문하고 집으로 돌아오는 경로 중 가장 짧은 것 찾기
			// 모두 방문하고 집에 돌아가는 경로 중 총 이동거리가 가장 짧은 경로 찾기

			st = new StringTokenizer(br.readLine());
			company = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			house = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			customers = new Point[n];
			for (int i = 0; i < n; i++) {
				customers[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			visited = new boolean[n];
			answer = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				int houseToCus = Math.abs(customers[i].x - house.x) + Math.abs(customers[i].y - house.y);
				visited[i] = true;
				permutation(1,i, houseToCus);
				visited[i] = false;
			}
			
			System.out.println("#" + tc + " " + answer);

		}
	}

	private static void permutation(int depth, int beforeIdx, int total) {
		if (total > answer) {
			return;
		}

		if (depth == n) {
			int cusToCom = Math.abs(customers[beforeIdx].x - company.x) + Math.abs(customers[beforeIdx].y - company.y);
			answer = Math.min(answer, total + cusToCom);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			int cusToCus = Math.abs(customers[beforeIdx].x - customers[i].x)
					+ Math.abs(customers[beforeIdx].y - customers[i].y);
			permutation(depth + 1,i, total + cusToCus);
			visited[i] = false;
		}
	}
}
