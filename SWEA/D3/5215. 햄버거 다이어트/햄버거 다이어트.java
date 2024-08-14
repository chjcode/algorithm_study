
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.io.*;

public class Solution {

	static int n, l,t,k,answer;
	static List<Hamburger> lst, comLst;
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

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			
			lst = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				t = Integer.parseInt(st.nextToken());
				k = Integer.parseInt(st.nextToken());
				
				lst.add(new Hamburger(t, k));
			}
			

			answer = 0;
			comLst = new ArrayList<>();
			combination(0,0,0,0);
			
			System.out.println("#" + tc + " " + answer);
		}

	}
	
	private static void combination(int start,int cnt, int totalKal, int totalTaste) {
//		if (cnt == n) {
//			return;
//		}
		if (totalKal > l) {
			return;
		}
		answer = Math.max(answer, totalTaste);
	
		for (int i = start; i < n; i++) {
			combination(i+1,cnt+1,totalKal+lst.get(i).k, totalTaste+lst.get(i).t);
		}
	}
}
