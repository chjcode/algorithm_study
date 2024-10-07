import java.util.*;
import java.io.*;

public class Main {
	
	static long[] dp;	// idx 개의 성냥개비로 만들 수 있는 가장 작은 숫자 저장
	static int[] arr = {0,0,1,7,4,2,0,8};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		dp = new long[101];
		Arrays.fill(dp, Long.MAX_VALUE);
		
		dp[2] = 1;
		dp[3] = 7;
		dp[4] = 4;
		dp[5] = 2;
		dp[6] = 6;
		dp[7] = 8;
		dp[8] = 10;
		
		for (int i = 9; i < 101; i++) {
			for (int j = 2; j < 8; j++) {
				long temp = dp[i-j] * 10 + arr[j];
				dp[i] = Math.min(temp, dp[i]);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < t; tc++) {
			int num = Integer.parseInt(br.readLine());
			
			//최소
			sb.append(dp[num]).append(" ");
			
			//최대
			if (num % 2 == 0) {
				for (int i = 0; i < num/2; i++) {
					sb.append(1);
				}
			} else {
				sb.append(7);
				for (int i = 0; i < (num-3)/2; i++) {
					sb.append(1);
				}
			}
			
			sb.append("\n");
			
		}
		
		System.out.println(sb.toString());
		
	}

}
