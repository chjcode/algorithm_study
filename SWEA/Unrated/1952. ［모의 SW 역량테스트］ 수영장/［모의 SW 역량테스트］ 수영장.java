
import java.util.*;
import java.io.*;

public class Solution {
	
	static int total,dayPass,monthPass,threeMonthPass,yearPass;
	static int[] plan;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < t+1; tc++) {

			st = new StringTokenizer(br.readLine());
			dayPass = Integer.parseInt(st.nextToken());
			monthPass = Integer.parseInt(st.nextToken());
			threeMonthPass = Integer.parseInt(st.nextToken());
			yearPass = Integer.parseInt(st.nextToken());
			
			plan = new int[12];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			
			total = yearPass;
			dfs(0,0);
			
			System.out.println("#" + tc + " " + total);
		}
		
	}
	
	private static void dfs(int depth, int cnt) {
		
		if (depth >= 12) {
			total = Math.min(total, cnt);
			return;
		}
		
		if (plan[depth] == 0) {
			dfs(depth+1,cnt);
		}else {
			dfs(depth+1, cnt+dayPass*plan[depth]);
			dfs(depth+1, cnt+ monthPass);
			dfs(depth+3, cnt+threeMonthPass);	
		}
		
	}

}
