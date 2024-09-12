import java.util.*;
import java.io.*;

public class Main {

	static int n,k;
	static long max,answer;
	static long[] graph;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		graph = new long[n];
		max = 0;
		for (int i = 0; i < n; i++) {
			graph[i] = Long.parseLong(br.readLine());
			max = Math.max(max, graph[i]);
		}
		
		answer = binarySearch(max);
		System.out.println(answer);
		
	}
	
	private static long binarySearch(long num) {
		long left = 1;
		long right = num;
		
		while (left <= right) {
			long mid = (left + right) /2;
			
			// 랜선 개수 확인
			long cnt = 0;
			for (int i = 0; i < n; i++) {
				cnt += graph[i]/mid;
			}
			
			if (cnt >= k) {
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		
		
		return left-1;
	}

}
