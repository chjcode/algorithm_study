
import java.io.*;
import java.util.*;

public class Solution {
	
	static int n,answer;
	static int[][] graph;
	static int[] seq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < t+1; tc++) {
			n = Integer.parseInt(br.readLine());
			
			graph = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			answer = Integer.MAX_VALUE;
			seq = new int[n];
			for (int i = n/2; i < n; i++) {
				seq[i] = 1;
			}
			
			
			do {
				int[] a = new int[n/2];
				int[] b = new int[n/2];
				int idxA = 0;
				int idxB = 0;
				for (int i = 0; i < n; i++) {
					if (seq[i] == 0) {
						a[idxA++] = i;
					}else {
						b[idxB++] = i;
					}
				}

				int scoreA = 0;
				int scoreB = 0;
				for (int i = 0; i < n/2; i++) {
					for (int j = 0; j < n/2; j++) {
						if (i==j) {
							continue;
						}
						scoreA += graph[a[i]][a[j]];
						scoreB += graph[b[i]][b[j]];
					}
				}
				
				answer = Math.min(answer, Math.abs(scoreA-scoreB));
				
			} while(nextPermutation(seq));

			System.out.println("#"  + tc + " " + answer);
		}
	}
	
	private static boolean nextPermutation(int[] arr) {
		int i = arr.length - 1;
		// 1. 기준점 찾기
		while (i > 0 && arr[i-1] >= arr[i]) {
			i--;
		}
		
		if (i == 0) {
			return false;
		}
		
		// 2. 꼭대기 앞 교환위치에 교환할 값 (i-1위치 값보다 큰 값 중 가장 작은 값) 자리 찾기
		int j = arr.length - 1;
		while (arr[j] <= arr[i-1]) {
			j--;
		}
		
		// 3. 자리 바꾸기
		swap(arr,i-1,j);
		
		// 4. 다시 정렬하기
		j = arr.length - 1;
		while (i < j) {
			swap(arr,i,j);
			i++;
			j--;
		}
		
		return true;
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}

