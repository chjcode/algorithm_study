import java.util.*;
import java.io.*;

public class Main {
	
	static int n,k,total,answer;
	static int[][] graph;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		graph = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int temp = Integer.parseInt(st.nextToken());
				graph[i][j] = temp;
			}
		}
		
		k = n/2;
		answer = Integer.MAX_VALUE;
		for (int i = 0; i < (1<<n); i++) {	// 0001 ~ 1110으로?
			int cnt1 = 0;
			int cnt2 = 0;
			List<Integer> lst1 = new ArrayList<>();
			List<Integer> lst2 = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0) {
					lst1.add(j);
				} else {
					lst2.add(j);
				}
			}
			
			for (int a = 0; a < lst1.size(); a++) {
				for (int b = a+1; b < lst1.size(); b++) {
					cnt1 += (graph[lst1.get(a)][lst1.get(b)]+graph[lst1.get(b)][lst1.get(a)]);
				}
			}
			
			for (int a = 0; a < lst2.size(); a++) {
				for (int b = a+1; b < lst2.size(); b++) {
					cnt2 += (graph[lst2.get(a)][lst2.get(b)]+graph[lst2.get(b)][lst2.get(a)]);
				}
			}
			
			answer = Math.min(answer, Math.abs(cnt1-cnt2));
		}
		System.out.println(answer);
	}
}
