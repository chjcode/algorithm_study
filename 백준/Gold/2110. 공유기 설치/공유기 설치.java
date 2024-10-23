import java.util.*;
import java.io.*;

public class Main {
	
	static int n,c;
	static int[] graph;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		graph = new int[n];
		for (int i = 0; i < n; i++) {
			graph[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(graph);
		// 1 2 4 8 9
		int left = 1;
		int right = graph[n-1];
		int target = -1;
		while (left <= right) {
			int mid = (left + right) / 2;
			// 개수가 적거나 같으면 공유기 사이 거리 늘리기
			if (count(mid) >= c) {
				target = mid;
				left = mid + 1;
			} else {
				right = mid -1;
			}
		}
		
		System.out.println(target);
		
	}
	
	private static int count(int len) {
		int cnt = 1;
		int now = graph[0];
		for (int i = 1; i < n; i++) {
			if (graph[i] - now >= len) {
				cnt++;
				now = graph[i];
			}
		}
		
		return cnt;
	}
}
