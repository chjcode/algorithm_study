import java.util.*;
import java.io.*;

public class Main {

	static int n,cnt;
	static boolean du;
	static int[] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		graph = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			graph[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(graph);
		
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			int target = graph[i];
			int left = 0;
			int right = n-1;
			
			while (left < right) {
				int sum = graph[left] + graph[right];
				if (left == i) {
					left++;
					continue;
				}
				
				if (right == i) {
					right--;
					continue;
				}
				
				if (sum == target) {
					cnt++;
					break;
				} else if (sum > target) {
					right--;
				} else if (sum < target) {
					left++;
				}
			}
			
		}
		
		System.out.println(cnt);
		
	}
	
}

