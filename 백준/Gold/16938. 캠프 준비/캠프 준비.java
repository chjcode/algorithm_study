import java.util.*;
import java.io.*;

public class Main {

	static int n,l,r,x;
	static int[] graph;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		graph = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			graph[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		for (int i = 0; i < (1<<n); i++) {
			int cnt = 0;
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int sum = 0;
			
			for (int j = 0; j < n; j++) {
				if ((i & (1<<j)) != 0) {
					cnt++;
					sum += graph[j];
					min = Math.min(min, graph[j]);
					max = Math.max(max, graph[j]);
				}
			}
			
			if (cnt >= 2 && l <= sum && sum <= r && (max-min) >= x) {
				answer++;
			}
		}
		
		System.out.println(answer);
		
	}

}
