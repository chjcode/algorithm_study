import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder output = new StringBuilder();
	
	static int read() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	public static void main(String[] args) throws Exception {
		int N = read();
		int[] dist = new int[N+1];
		int sumDist = 0;
		
		for(int i = 0 ; i < N ; i++) {
			int d = read();
			dist[i] = d;
			sumDist += d;
		}
		
		/**
		 * 투포인터
		 * 작으면 오른쪽으로 늘려가고 크면 좁혀간다
		 */
		
		int max = Integer.MIN_VALUE;
		int right = 0, left = 0;
		int now = dist[left];
		
		while(left <= right && right < N) {
			if(now < sumDist - now) {
				max = Math.max(max, now);
				now += dist[++right];
			} else {
				max = Math.max(max, sumDist - now);
				now -= dist[left++];
			}
		}
		System.out.print(max);
	}
}
