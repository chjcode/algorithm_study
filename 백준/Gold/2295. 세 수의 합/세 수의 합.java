import java.util.*;
import java.io.*;

public class Main {
	
	static int n,answer;
	static int[] u;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		u = new int[n]; 
		for (int i = 0; i < n; i++) {
			u[i] = Integer.parseInt(br.readLine());
		}
		
		//두개의 합 배열 만들기
		int[] sum = new int[n*(n+1)/2];
		int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				sum[idx++] = u[i] + u[j];
			}
		}
		
		Arrays.sort(sum);
		
		
		int max = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int target = u[i] - u[j];
				if (Arrays.binarySearch(sum, target) >= 0) {
					max = Math.max(max, u[i]);
				}
			}
		} 
		
		System.out.println(max);
	}

}
