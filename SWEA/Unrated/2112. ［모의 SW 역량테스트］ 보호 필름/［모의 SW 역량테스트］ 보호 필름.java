
import java.io.*;
import java.util.*;

public class Solution {

	static int d,w,k,answer;
	static int[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < t + 1; tc++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			graph = new int[d][w];

			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			answer = Integer.MAX_VALUE;
			if (checkCells(graph)) {
				answer = 0;
			}else{
				find();
			}

			System.out.println("#" + tc + " " + answer);
		}

	}

	private static void find() {
		for (int i = 1; i <= k; i++) {
			combination(0,0,i);
			if (answer != Integer.MAX_VALUE) {
				break;
			}
		}
	}

	private static void combination(int start, int cnt, int end){
		// 이미 최소 투입 횟수보다 큰 경우 가지치기
		if (cnt >= answer) {
			return;
		}
		if (cnt == end) {
			if (checkCells(graph)) {
				answer = Math.min(answer, cnt);
			}
			return;
		}

		for (int i = start; i < d; i++) {
			int[] originalRow = graph[i].clone();

			// A 투약
			for (int j = 0; j < w; j++) {
				graph[i][j] = 0;
			}
			combination(i + 1, cnt + 1, end);

			// B 투약
			for (int j = 0; j < w; j++) {
				graph[i][j] = 1;
			}
			combination(i + 1, cnt + 1, end);

			// 원본배열로 원복
			graph[i] = originalRow.clone();
		}
	}

	//연속된 최소 셀 개수 체크
	private static boolean checkCells(int[][] graph) {
		for (int j = 0; j < w; j++) {
			int cnt = 1;
			int stack = graph[0][j];
			boolean flag = false;
			for (int i = 1; i < d; i++) {
				if (stack == graph[i][j]) {
					cnt++;
				}else{
					stack = graph[i][j];
					cnt = 1;
				}
				if (cnt >= k) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				return false;
			}
		}
		return true;
	}
}
