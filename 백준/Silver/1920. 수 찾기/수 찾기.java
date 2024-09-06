import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] nArr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nArr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nArr);
		
		int m = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		int answer = 0;
		for (int i = 0; i < m; i++) {
			int target = Integer.parseInt(st.nextToken());
			int temp = Arrays.binarySearch(nArr, target);
			if (temp >= 0) {
				answer = 1;
			}else {
				answer = 0;
			}
			
			System.out.println(answer); 
		}	
	}

}
