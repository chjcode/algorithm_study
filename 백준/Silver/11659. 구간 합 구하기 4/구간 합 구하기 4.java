
import java.io.*;
import java.util.*;

public class Main {
	
	static int n,m,answer;
	static int[] lst,dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		lst = new int[n];
		for (int i = 0; i < n; i++) {
			lst[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[n];
		dp[0] = lst[0];
		for (int i = 1; i < n; i++) {
			dp[i] = dp[i-1] + lst[i];
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			if (a == 0) {
				System.out.println(dp[b]);
			} else {
				System.out.println(dp[b]-dp[a-1]);
			}
		}
		
	}
}
