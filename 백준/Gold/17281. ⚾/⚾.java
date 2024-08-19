
import java.util.*;
import java.io.*;

public class Main {

	static int n,answer;
	static int[][] player;
	static int[] seq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		player = new int[n][9];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				player[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 9 명을 어떤 순서로 놓는지에 따라 점수가 달라짐 -> nextPermutation 사용
		// 4번 타자 고정
		seq = new int[9];

		int[] tempSeq = new int[8];
		for(int i = 0;i<8;i++) {
			tempSeq[i] = i+1;
		}
		answer = 0;
		do{
			for(int i =0; i < 3; i++) {
				seq[i] = tempSeq[i];
			}
			seq[3] = 0;
			for (int i =3; i < 8; i++) {
				seq[i+1] = tempSeq[i];
			}
			play();
		}while(nextPermutation(tempSeq));

		System.out.println(answer);
	}

	private static void play(){
		int score = 0;
		int runnerIdx = 0;

		for (int i = 0; i < n; i++) {
			boolean[] base = new boolean[3];	// 1루, 2루, 3루
			int out = 0;
			while (out<3) {
				int currentRunner = seq[runnerIdx];
				int result = player[i][currentRunner];

				if (result == 0){	// 아웃
					out++;
				} else if (result == 1) {	// 안타
					if (base[2]){
						score++;
					}
					base[2] = base[1];
					base[1] = base[0];
					base[0] = true;
				} else if (result == 2) {	// 2루타
					if (base[2]) {
						score++;
					}
					if (base[1]) {
						score++;
					}
					base[2] = base[0];
					base[1] = true;
					base[0] = false;
				} else if (result == 3) {    // 3루타
					if (base[2]) {
						score++;
					}
					if (base[1]) {
						score++;
					}
					if (base[0]) {
						score++;
					}
					base[2] = true;
					base[1] = false;
					base[0] = false;
				} else if (result == 4) {	// 홈런
					score++;
					if (base[2]) {
						score++;
					}
					if (base[1]) {
						score++;
					}
					if (base[0]) {
						score++;
					}
					base[2] = false;
					base[1] = false;
					base[0] = false;
				}
				runnerIdx = (runnerIdx + 1) % 9;
			}
		}

		answer = Math.max(answer, score);
	}

	private static boolean nextPermutation(int arr[]) {
		int i = 7;
		while (i > 0 && arr[i - 1] >= arr[i]) i--;

		if (i == 0) return false;

		int j = 7;
		while (arr[i - 1] >= arr[j]) j--;

		swap(arr,i - 1, j);

		j = 7;
		while (i < j) swap(arr, i++, j--);

		return true;
	}
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
