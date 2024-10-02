import java.util.*;
import java.io.*;

public class Solution {

	static int n;
	static int[] arr;
	static List<Integer> lst;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < t+1; tc++) {
			n = Integer.parseInt(br.readLine());
			
			arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// lst : 최장부분증가수열 길이 구하는데 사용
			lst = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				// lst에서 arr[i]가 들어갈 위치 찾기
				if(i == 0) {
					lst.add(arr[i]);
					continue;
				}
				int idx = Collections.binarySearch(lst, arr[i]);
				
				// lst에 arr[i]가 없으면 Collections.binarySearch는 들어갈 위치를 음수로 반환
				if (idx < 0) {
					// 양수로 변환
					idx = -(idx+1);
				}
				
				if (idx == lst.size()) {
					lst.add(arr[i]);
				} else{
					lst.set(idx, arr[i]);
				}
			}
			
			System.out.println("#" + tc + " " + lst.size());
			
		}
		
		
	}
	
	
}