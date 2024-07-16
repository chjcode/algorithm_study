
import java.util.*;
import java.io.*;

public class Main {
	
	static int n,k;
	static int[] visited;

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		visited = new int[100001];
		
		if (n==k) {
			System.out.println(0);
		} else {
			bfs(n);
		}
	}
	public static void bfs(int n) {
		Queue<Integer> que = new LinkedList<>();
		que.add(n);
		visited[n] = 1;
		
		while (!que.isEmpty()) {
			int now = que.poll();
			
			for (int i = 0; i < 3; i++) {
				int next;
				if (i == 0) {
					next = now + 1;
				} else if (i == 1){
					next = now - 1;
				} else {
					next = 2 * now;
				}
				
				if (next == k) {
					System.out.println(visited[now]);
					return;
				}
				
				if (0 <= next && next <= 100000 && visited[next]== 0) {
					que.add(next);
					visited[next] = visited[now] + 1;
				}
			}
		}
	}

}
