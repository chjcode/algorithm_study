import java.io.*;
import java.util.*;

public class Main {

	static int n,m,answer;
	static boolean over5;
	static List<List<Integer>> lst;
	static boolean[] visited;
	
	static class Edge{
		int x;
		int y;
		Edge(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		lst = new ArrayList<>();
		for (int i = 0; i < n; i++) {
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
		over5 = false;
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			dfs(i,1);
			if (over5) break;
		}
		
		if (over5) {
			answer = 1;
		}
		System.out.println(answer);
	}
	
	private static void dfs(int node, int cnt) {
		if (cnt == 5) {
			over5 = true;
			return;
		}
		
		visited[node] = true;
		for (int i = 0; i < lst.get(node).size();i++) {
			if (!visited[lst.get(node).get(i)]) {
				dfs(lst.get(node).get(i), cnt+1);
			}
		}
		visited[node] = false;
	}

}
