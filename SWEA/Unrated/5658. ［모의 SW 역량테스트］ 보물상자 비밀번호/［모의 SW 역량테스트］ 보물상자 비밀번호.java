import java.io.*;
import java.util.*;

public class Solution {
	
	static int n,k;
	static char[] charNums;
	static TreeSet<Integer> set;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < t+1; tc++) {
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			String s = br.readLine();
			charNums = new char[n];
			for (int i = 0; i < n; i++) {
				charNums[i] = s.charAt(i);
			}
			
			
			int start = 0;
			set = new TreeSet<>(Collections.reverseOrder());
			while (start < n/4) {
				sb = new StringBuilder();
				for (int i = start; i < n; i++) {
					sb.append(charNums[i]);
					if (sb.length() == n/4) {
						set.add(Integer.parseInt(sb.toString(),16));
						sb = new StringBuilder();
					}
				}
				for (int i = 0; i < start; i++) {
					sb.append(charNums[i]);
					if (sb.length() == n/4) {
						set.add(Integer.parseInt(sb.toString(),16));
						sb = new StringBuilder();
					}
				}
				start++;
			}
			
			List<Integer> sortedList = new ArrayList<>(set);
			
			System.out.println("#" + tc + " " + sortedList.get(k-1));
			
		}
	}
}
