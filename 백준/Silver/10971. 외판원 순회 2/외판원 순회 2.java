
import java.util.*;
import java.io.*;

public class Main {

	static int n, answer;
	static int[][] graph;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		graph = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		answer = Integer.MAX_VALUE;
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			visited[i] = true;
			permutation(i,i,0,0);
			visited[i] = false;
		}
		
		System.out.println(answer);

	}

	private static void permutation(int start, int cur, int depth, int sum) {
		if (depth == n-1) {
			// 처음 출발지로 가는 길이 있으면
			if (graph[cur][start] > 0) {
				sum += graph[cur][start];
				answer = Math.min(answer, sum);
			}
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i]) continue;	// 이미 방문한 도시이면 생략
			if (graph[cur][i] == 0) continue;	// 길이 없으면 생략
			visited[i] = true;
			permutation(start, i, depth+1,sum+graph[cur][i]);
			visited[i] = false;
		}

	}
}
