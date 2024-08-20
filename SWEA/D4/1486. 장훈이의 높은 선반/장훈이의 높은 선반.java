
import java.util.*;
import java.io.*;

public class Solution {
	
	static int n,b,hSum,answer;
	static int[] h;
	static boolean[] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < t+1; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			h = new int[n];
			hSum = 0;		// 전체 직원 키의 합
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				h[i] = Integer.parseInt(st.nextToken());
				hSum += h[i];
			}
			
			dp = new boolean[hSum+1];
			dp[0] = true;
			answer = Integer.MAX_VALUE;
			
			for(int i = 0; i < n; i++) {
				for (int j = hSum; j > -1; j--) {
					if(dp[j]) {
						int nextIdx = j + h[i];
						if (nextIdx <= hSum) {
							dp[nextIdx] = true;
						}
						
						if (nextIdx >= b) {
							answer = Math.min(answer, nextIdx);
						}
					}
				}
			}
			
			System.out.println("#" + tc + " " + (answer-b));
			
		}
		
		
	}
}
