import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder output = new StringBuilder();

	static int readInt() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	static long readLong() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Long.parseLong(st.nextToken());
	}
	
	public static void main(String[] args) throws Exception {
		int N = readInt();
		long[] dist = new long[N];
		long sumDist = 0L;
		
		for(int i = 0 ; i < N ; i++) {
			long d = readLong();
			dist[i] = d; sumDist += d;
		}
		long max = Long.MIN_VALUE;
		for(int i = 0 ; i < N ; i++) {
			long left = 0;
			for(int j = i ; j < N ; j++) {
				left += dist[j];
				max = Math.max(max, Math.min(left, sumDist-left));
			}
		}
		System.out.print(max);
	}
}