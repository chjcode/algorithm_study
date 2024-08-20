import java.util.*;

public class Solution {
	
	static int n, answer;
	static int[] hLst;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			hLst = new int[n];
			
			for (int i = 0; i < n; i++) {
				hLst[i] = sc.nextInt();
			}
			
			answer = 0;
			int temp = 0;
			int stack = hLst[0];
			boolean downFlag = false;
			
			for (int i = 1; i < n; i++) {
				if (stack < hLst[i]) {  // 이전 값보다 크면 (올라가면)
					if (downFlag) {
						// 내려간 적 있는데 올라오면
						temp = 0;  // temp 초기화
						downFlag = false;
					}
					temp++;
				} else {  // 이전 값보다 작으면 (내려가면)
					downFlag = true;
					answer += temp;
				}
				stack = hLst[i];
			}
			
			System.out.println("#" + tc + " " + answer);
		}
		
		sc.close();
	}
}
