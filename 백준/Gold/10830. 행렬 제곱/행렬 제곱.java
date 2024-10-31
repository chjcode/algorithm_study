import java.util.*;
import java.io.*;

public class Main {
	
	static int n;
	static long b;
	static int[][] a, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		b = Long.parseLong(st.nextToken());
		
		a = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(st.nextToken()) % 1000;
			}
		}
		
		answer = calculate(b);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	private static int[][] calculate(long cnt) {
		if (cnt == 1) {
			return a;
		}
		
		int[][] result = new int[n][n];
		
		int[][] temp = calculate(cnt/2);
		
		result = matrixCal(temp, temp);
		//홀수
		if (cnt % 2 != 0) {
			result = matrixCal(a, result);
		}
		
		return result;

	}
	
	private static int[][] matrixCal(int[][] a, int[][] b) {
		int[][] temp = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int sum = 0;
				for (int k = 0; k < n; k++) {
					sum += a[i][k] * b[k][j];
				}
				temp[i][j] = sum % 1000;
			}
		}
		
		return temp;
	}

}
