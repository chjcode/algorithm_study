import java.util.*;
import java.io.*;

public class Main {
	
	static int n,k,p,x,answer;
	static boolean[][] number;
	static int[][] diff;
	static int[] display;
	static int[] reverse;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		number = new boolean[10][7];
		number[0] = new boolean[]{true, true, true, false, true, true, true};
		number[1] = new boolean[]{false, false, true, false, false, true, false};
		number[2] = new boolean[]{true, false, true, true, true, false, true};
		number[3] = new boolean[]{true, false, true, true, false, true, true};
		number[4] = new boolean[]{false, true, true, true, false, true, false};
		number[5] = new boolean[]{true, true, false, true, false, true, true};
		number[6] = new boolean[]{true, true, false, true, true, true, true};
		number[7] = new boolean[]{true, false, true, false, false, true, false};
		number[8] = new boolean[]{true, true, true, true, true, true, true};
		number[9] = new boolean[]{true, true, true, true, false, true, true};
		
		diff = new int[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				int cnt = 0;
				for (int k = 0; k < 7; k++) {
					if (number[i][k] != number[j][k]) cnt++;
				}
				diff[i][j] = cnt;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		//디스플레이 개수 : k
		//반전 개수 : p
		//올바른 수 제한 : 1이상 n 이하
		//멈춰있는 층 : x 
		
		// display에 원래 층수 숫자 채우기
		display = new int[k];
		int cnt = 0;
		int temp = x;
		while (temp > 0) {
			cnt++;
			int num = temp % 10;
			display[k-cnt] = num;
			temp /= 10;
		}
		
		for (int i = 0; i < k-cnt; i++) {
			display[i] = 0;
		}
		
//		System.out.println("display : " + Arrays.toString(display));
		
		answer = 0;
		reverse = new int[k];
		find(0,0,p);
		
		
		System.out.println(answer);
		
		
	}
	
	
	private static void find(int depth, int num, int cnt) {
		
		if (num > n) {
			return;
		}
		
		if (depth == k) {
			if (num > 0 && num != x) {
//				System.out.println(Arrays.toString(reverse));
//				System.out.println(num);
				answer++;
			}
			
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			// 변환 가능한 숫자면
			if (diff[display[depth]][i] <= cnt) {
				reverse[depth] = i;
				find(depth+1, num+i*(int)Math.pow(10, k-depth-1), cnt-diff[display[depth]][i]);
			}
			
		}
	} 
}
