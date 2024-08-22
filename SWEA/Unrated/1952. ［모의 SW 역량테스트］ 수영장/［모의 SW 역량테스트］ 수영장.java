
import java.util.*;
import java.io.*;

public class Solution {
	
	static int total,oneDayPass,oneMonthPass,threeMonthPass,oneYearPass;
	static int[] charge, plan,monthPass;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < t+1; tc++) {
			charge = new int[4];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				charge[i] = Integer.parseInt(st.nextToken());
			}
			
			plan = new int[12];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			
			oneDayPass = charge[0];
			oneMonthPass = charge[1];
			threeMonthPass = charge[2];
			oneYearPass = charge[3];
			
			total = oneYearPass;
			dfs(0,0);
			
			System.out.println("#" + tc + " " + total);
		}
		
	}
	
	private static void dfs(int depth, int cnt) {
		
		if (depth >= 12) {
			total = Math.min(total, cnt);
			return;
		}
		
		if (plan[depth] > 0) {
			dfs(depth+1, cnt+oneDayPass*plan[depth]);
			dfs(depth+1, cnt+ oneMonthPass);
			dfs(depth+3, cnt+threeMonthPass);	
		}else {
			dfs(depth+1,cnt);
		}
		
	}

}
