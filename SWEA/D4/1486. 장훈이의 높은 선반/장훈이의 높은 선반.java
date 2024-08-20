
import java.util.*;
import java.io.*;

public class Solution {

	static int n, b, hSum, answer;
	static int[] h;
	static List<Integer> lst;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < t + 1; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			h = new int[n];
			hSum = 0; // 전체 직원 키의 합
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				h[i] = Integer.parseInt(st.nextToken());
				hSum += h[i];
			}
			
			lst = new ArrayList<>();
			answer = Integer.MAX_VALUE;
			dfs(0,0,0);
			
			System.out.println("#" + tc + " " + (answer - b));
		}

	}

	private static void dfs(int start, int cnt, int sum) {
		
		if (sum >= b) {
			answer = Math.min(answer, sum);
			return;
		}
		
		if (cnt == n) {
			return;
		}

		for (int i = start; i < n; i++) {
			dfs(i+1,cnt+1,sum+h[i]);
		}
	}

}
