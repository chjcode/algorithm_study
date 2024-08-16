import java.util.*;
import java.io.*;

public class Solution {
	
	static int n,l,answer;
	static List<Hamburger> lst;
	
	static class Hamburger{
		int t;
		int k;
		Hamburger(int t, int k) {
			this.t = t;
			this.k = k;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < t+1; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			
			lst = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int taste = Integer.parseInt(st.nextToken());
				int kal = Integer.parseInt(st.nextToken());
				
				lst.add(new Hamburger(taste, kal));
			}
			
			answer = 0;
			
			for (int i = 0; i < (1<<n); i++) {
				int totalK = 0;
				int totalT = 0;
				boolean flag = true;
				for (int j = 0; j < n; j++) {
					if ((i & (1<<j)) != 0) {
						totalK += lst.get(j).k;
						totalT += lst.get(j).t;
					}
					
					if (totalK > l) {
						flag = false;
						break;
					}
				}
				if (flag) {
					answer = Math.max(answer, totalT);
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
		
		
	}

}
