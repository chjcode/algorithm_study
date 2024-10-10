import java.util.*;
import java.io.*;

public class Main {
	
	static int n,m;
	static int[] graph;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		graph = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			graph[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(graph);
		
		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int temp = Arrays.binarySearch(graph, Integer.parseInt(st.nextToken()));
			
			if (temp >= 0) {
				sb.append(1).append(" ");
			} else {
				sb.append(0).append(" ");
			}
		}
		
		System.out.println(sb.toString().trim());
		
	}
}
