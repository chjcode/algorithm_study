
import java.util.*;
import java.io.*;

public class Solution {
	static int n,minAnswer, maxAnswer;
	static int[] operations, numbers,seq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < t+1; tc++) {
			n = Integer.parseInt(br.readLine());

			operations = new int[4];
			seq = new int[n-1];
			int tmpIdx = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i ++) {
				operations[i] = Integer.parseInt(st.nextToken());
				for (int j = 0; j < operations[i]; j++){
					seq[tmpIdx++] = i;
				}
			}

			numbers = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i ++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}

			minAnswer = Integer.MAX_VALUE;
			maxAnswer = Integer.MIN_VALUE;
			do {
				calculate();
			}while(nextPermutation());

			System.out.println("#" + tc + " " + (maxAnswer-minAnswer));
		}
	}
	private static void calculate(){
		int result = numbers[0];
		for (int i = 0; i < n-1; i++) {
			if (seq[i] == 0) {
				result += numbers[i+1];
			} else if (seq[i] == 1) {
				result -= numbers[i+1];
			} else if (seq[i] == 2) {
				result *= numbers[i+1];
			} else if (seq[i] == 3) {
				result /= numbers[i+1];
			}
		}
		minAnswer = Math.min(minAnswer, result);
		maxAnswer = Math.max(maxAnswer, result);
	}

	private static boolean nextPermutation() {
		int i = n-2;
		while(i > 0 && seq[i-1] >= seq[i]) i--;

		if (i==0) return false;

		int j = n-2;
		while(seq[i-1] >= seq[j]) j--;

		swap(i-1,j);

		j = n-2;
		while(i<j) swap(i++,j--);

		return true;
	}

	private static void swap(int i, int j) {
		int temp = seq[i];
		seq[i] = seq[j];
		seq[j] = temp;
	}
}

//10
//5
//2 1 0 1
//3 5 3 7 9