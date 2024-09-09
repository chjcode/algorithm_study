import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 인식할 수 있는 알파벳의 종류의 최대 개수
		String str = br.readLine();
		int[] arr = new int[str.length()+1];
		for(int i = 0 ; i < str.length() ; i++) {
			arr[i] = str.charAt(i) - 'a';
		}
		
		int[] count = new int[26];
		
		int right = 0;
		int left = 0;
		int cnt = 0; // 등장한 문자의 개수
		int maxLength = 0;
		
		while(left <= right && right < str.length()) {
			int now = arr[right];
			if(count[now] == 0) {
				// 아직 등장하지 않은 문자라면 새로운 문자
				if(cnt < N) {
					// 추가 가능
					cnt++; // 문자 추가
					count[now]++; // 현재 문자의 등장 개수 추가
					right++; // 오른쪽으로 넓히기
					maxLength = Math.max(maxLength, right-left);
				} 
				else {
					// 추가 불가능
					// 왼쪽으로 좁히고 그 문자 등장 개수 감소
					if(--count[arr[left++]] == 0) cnt--;
				}
			} else {
				// 이미 등장한 문자라면 개수만 늘려주기
				count[now]++; // 현재 문자의 등장 개수 추가
				right++; // 오른쪽으로 넓히기
				maxLength = Math.max(maxLength, right-left);
			}
		}
		System.out.print(maxLength);
	}
}