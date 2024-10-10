import java.util.*;
import java.io.*;

public class Solution {

	static int n,x;
	static int[][] graph;
	static int count;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < t+1; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			
			graph = new int[n][n];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			count = 0;
			
			for (int i = 0; i < n; i++) {
				if (check(graph[i])) count++;
			}
			
			for (int i = 0; i < n; i++) {
				int[] column = new int[n];
				for (int j = 0; j < n; j++) {
					column[j] = graph[j][i];
				}
				if (check(column)) count++;
			}
			
			System.out.println("#" + tc + " " + count);
		}
		
	}
	
	private static boolean check(int[] line) {
		boolean[] used = new boolean[n];	// 경사로 사용 여부 기록
		
		for (int i = 1; i < n; i++) {
			// 높이가 같을 때
			if (line[i] == line[i-1]) continue;
			
			// 현재 idx가 이전 idx보다 1이 크면 올라가는 경사로 설치
			else if (line[i] - line[i-1] == 1) {
				for (int j = i-1; j >= i-x; j-- ) {
					if (j < 0 || line[j] != line[i-1] || used[j]) {
						return false;
					}
					used[j] = true;
				}
			}
			else if (line[i-1] - line[i] == 1) {
				for (int j = i; j < i+x; j++) {
					if (j >= n || line[j] != line[i] || used[j]) {
						return false;
					}
					used[j] = true;
				}
			}
			// 높이가 2이상 차이 나면 설치 불가
			else {
				return false;
			}
		}
		
		return true;
	}

}
