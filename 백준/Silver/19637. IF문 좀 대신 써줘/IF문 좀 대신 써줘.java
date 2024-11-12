import java.util.*;
import java.io.*;

public class Main {
	
	static int n,m;
	static Grade[] arr;
	
	static class Grade implements Comparable<Grade>{
		String name;
		int num;
		int idx;
		
		Grade (String name, int num, int idx) {
			this.name = name;
			this.num = num;
			this.idx = idx;
		}
		
		@Override
		public int compareTo(Grade g) {
			
			if (this.num < g.num) {
				return -1;
			} else if (this.num == g.num) {
				if (this.idx < g.idx) {
					return -1;
				} else {
					return 1;
				}
			} else {
				return 1;
			}

		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new Grade[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			
			arr[i] = new Grade(s, num,i);
		}
		
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(br.readLine());
			
			sb.append(arr[find(num)].name).append("\n");
		}
		
		System.out.println(sb);
		
		
	}
	
	private static int find(int target) {
		int left = 0;
		int right = n-1;
		
		int result = -1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid].num >= target) {
				result = mid;
				right = mid - 1; 
			} else {
				left = mid + 1;
			}
		}
		
		return result;
	}
}
