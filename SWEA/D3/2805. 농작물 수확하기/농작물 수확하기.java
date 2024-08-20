
import java.util.*;
import java.io.*;

public class Solution {
	
	static int n, answer;
	static int[][] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int t= Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < t+1; tc++) {
			n = Integer.parseInt(br.readLine());
			graph = new int[n][n];
			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				for (int j = 0; j < n; j++) {
					graph[i][j] = s.charAt(j) - '0';
				}
			} 
			
			answer = 0;
			
			//위
			for (int i = 0; i < n/2;i++) {
				for (int j = n/2-i; j < n/2+i+1; j++) {
					answer += graph[i][j];
				}
			}
			//중간
			for (int j = 0; j < n;j++) {
				answer += graph[n/2][j];
			}
			//아래
			for (int i = n/2+1; i < n; i++) {
				for (int j = i-n/2; j < n-(i-n/2); j++) {
					answer += graph[i][j];
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}

}
