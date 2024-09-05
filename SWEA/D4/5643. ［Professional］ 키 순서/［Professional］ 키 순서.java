import java.io.*;
import java.util.*;

public class Solution {
	
	static int n,m,a,b,cnt,answer;
	static List<List<Integer>> up,down;
	static int[][] graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < t+1; tc++) {
			n = Integer.parseInt(br.readLine());
			
			up = new ArrayList<>();
			down = new ArrayList<>(); 
			for (int i = 0; i< n+1; i++) {
				up.add(new ArrayList<>());
				down.add(new ArrayList<>());
			}
			
			m = Integer.parseInt(br.readLine());
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				
				up.get(a).add(b);
				down.get(b).add(a);
			}
			
			
			answer = 0;
			for (int i = 0; i < n+1; i++) {
				visited = new boolean[n+1];
				cnt = 0;
				findUp(i);
				visited = new boolean[n+1];
				findDown(i);
				
				if (cnt == n-1) {
					answer++;
				}
			}
			
			System.out.println("#" + tc + " " +answer);
		}
		
	}
	
	private static void findUp(int idx) {
		visited[idx] = true;
		for (int next : up.get(idx)) {
			if (visited[next]) continue;
			cnt++;
			findUp(next);
		}
	}
	
	private static void findDown(int idx) {
		visited[idx] = true;
		for (int next : down.get(idx)) {
			if (visited[next]) continue;
			cnt++;
			findDown(next);
		}
	}
}
