import java.util.*;
import java.io.*;

public class Main {

	static int n,answer;
	static int[] graph;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		graph = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			graph[i] = Integer.parseInt(st.nextToken());
		}
		
		answer = 0;
		for (int i = 0; i < n; i++) {
			answer = Math.max(answer, count(i));
		}
		
		System.out.println(answer);
		
	}
	
	private static int count(int idx) {
		int cnt = 0;
		double stack = 0;	//직전 건물과 기울기 저장
		
		for (int i = idx+1; i < n; i++) {
			double degree = (double)(graph[idx] - graph[i]) / (idx - i);
			
			if (i == idx+1 || stack < degree) {
				cnt++;
				stack = degree;
			}
		}
		
		stack = 0;
		
		for (int i = idx - 1; i > -1; i--) {
			double degree = (double)(graph[idx] - graph[i]) / (idx - i);
			
			if (i == idx-1 || stack > degree) {
				cnt++;
				stack = degree;
			}
		}
		
		return cnt;
	}

}
