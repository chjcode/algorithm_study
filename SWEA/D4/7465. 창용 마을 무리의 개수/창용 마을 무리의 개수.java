
import java.io.*;
import java.util.*;

public class Solution {
	
	static int n,m,answer;
	static boolean[] visited;
	static List<List<Integer>> lst;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < t+1; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			lst = new ArrayList<>();
			for (int i = 0; i < n+1; i++) {
				lst.add(new ArrayList<>());
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				lst.get(a).add(b);
				lst.get(b).add(a);
			}
			
			answer = 0;
			visited = new boolean[n+1];
			for (int i = 1; i < n+1; i++) {
				if (!visited[i]) {
					dfs(i);
					answer++;
				}
			}
			
			System.out.println("#" + tc + " " + answer);
			
		}
		
	}
	
	private static void dfs(int node) {
		
		if (!visited[node]) {
			visited[node] = true;
			for (int next : lst.get(node)) {
				dfs(next);
			}
		}
	}

}
