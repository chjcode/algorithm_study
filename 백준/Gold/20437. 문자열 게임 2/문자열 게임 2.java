import java.util.*;
import java.io.*;

public class Main {
	
	static List<Integer>[] lst;
	static int t,k,min,max;
	static String w;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//26개
		t = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < t; tc++) {
			w = br.readLine();
			k = Integer.parseInt(br.readLine());
			
			lst = new ArrayList[26];
			for (int i = 0; i < 26; i++) {
				lst[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < w.length(); i++) {
				lst[w.charAt(i)-'a'].add(i);
			}
			
			min = Integer.MAX_VALUE;
			max = 0;
			for (int i = 0; i < 26; i++) {
				if (lst[i].size() >= k) {
					//여기서 최소, 최대
					
					for (int j = 0; j <= lst[i].size()-k; j++) {
						int len = lst[i].get(j+k-1) - lst[i].get(j) + 1;
						min = Math.min(min, len);
						max = Math.max(max, len);
					}
				}
			}
			
			if (max == 0) {
				System.out.println(-1);
			} else {
				System.out.println(min + " " + max);
			}
		}
	}
}
