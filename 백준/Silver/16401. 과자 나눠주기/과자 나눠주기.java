
import java.util.*;
import java.io.*;

public class Main {
	
	static int m,n,max,answer;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		max = 0;
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		
		answer = binarySearch(1,max);
		
		System.out.println(answer);
	}
	
	private static int binarySearch(int left, int right) {
		int result = 0;
		while(left <= right) {
			int mid = left + (right - left) / 2;
			int cnt = 0;
			
			for (int i = 0; i < arr.length; i++) {
				cnt += arr[i] / mid;
			}
			
			if (cnt >= m) {
				result = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		return result;
	}

}
