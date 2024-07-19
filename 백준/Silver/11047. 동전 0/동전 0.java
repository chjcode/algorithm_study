import java.util.*;
import java.io.*;

public class Main {
	static int n,k,answer,cnt;
	static int[] arr;
	
	public static void main(String args[])throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int idx = n-1;
		answer = 0;
		cnt = 0;
		while (idx >= 0) {
			if (answer == k) {
				break;
			}
			if (answer + arr[idx] > k) {
				idx -= 1;
				continue;
			}
			
			answer += arr[idx];
			cnt += 1;
			
//			System.out.println(answer + "  " + cnt);
			
		}
		
		System.out.println(cnt);
	}
}