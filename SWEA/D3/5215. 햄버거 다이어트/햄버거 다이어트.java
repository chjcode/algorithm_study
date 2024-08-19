
import java.util.*;
import java.io.*;

public class Solution {

	static int n,l,answer;
	static List<Hamburger> lst;
	static int[] check;
	
	static class Hamburger{
		int t;
		int k;
		
		Hamburger(int t, int k) {
			this.t = t;
			this.k = k;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			
			lst = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				lst.add(new Hamburger(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			answer = 0;
			for (int i = 0; i < n; i++) {
				check = new int[n];
				for (int j = i ; j < n; j++) {
					check[j] = 1;
				}
				
				do {
					int totalK = 0;
					int totalT = 0;
					boolean flag = true;
					for (int a = 0; a < n; a++) {
						if (check[a] == 1) {
							totalK += lst.get(a).k;
							totalT += lst.get(a).t;
						}
						
						if (totalK > l) {
							flag = false;
							continue;
						}
						
						if (flag) {
							answer = Math.max(answer, totalT);
						}
					}
				}while (nextPermutation(check));
				
			}
			
			System.out.println("#" + tc + " " + answer);
			
		}
	}
	
	private static boolean nextPermutation(int[] arr) {
		int len = arr.length;
		int i = len - 1;
		
		while (i > 0 && arr[i-1] >= arr[i]) {
			i--;
		}
		
		if (i == 0) return false;
		
		int j = len - 1;
		while(arr[j] <= arr[i-1]) {
			j--;
		}
		
		swap(arr,i-1,j);
		
		j = len-1;
		while(i<j) {
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
