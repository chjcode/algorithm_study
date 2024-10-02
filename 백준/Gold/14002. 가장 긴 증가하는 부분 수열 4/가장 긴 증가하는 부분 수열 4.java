import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int[] arr,dp, prev;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[n];	// 길이 저장
		prev = new int[n];	// 이전 숫자 기록
		Arrays.fill(dp, 1);
		Arrays.fill(prev, -1);
		
		// LIS
		int maxLength = 1;	// 최장 길이
		int maxIndex = 0;	//최장 수열이 끝나는 위치
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				// 현재 숫자가 이전 숫자보다 큰지 확인 && 더 긴 수열로 갱신할 수 있을 때만 갱신
				if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					prev[i] = j;	// 이전 인덱스 기록
				}
			}
			
			// 최대 길이와 그 위치 갱신
			if (dp[i] > maxLength) {
				maxLength = dp[i];
				maxIndex = i;
			}
		}
		
		List<Integer> lst = new ArrayList<>();
		int currentIdx = maxIndex;
		while(currentIdx != -1) {
			lst.add(arr[currentIdx]);
			currentIdx = prev[currentIdx];	// 이전 원소로 이동
		}
		
		// 배열 거꾸로
		Collections.reverse(lst);
		
		System.out.println(maxLength);
		for (int num : lst) {
			System.out.print(num + " ");
		}
	}

}
