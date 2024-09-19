import java.io.*;
import java.util.*;

public class Main {

	static int n, k;
	
	static class Min{
		int loc;
		int cnt;
		
		Min(int loc, int cnt){
			this.loc = loc;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
	
		int[] visited = new int[n+1];
		Arrays.fill(visited, Integer.MAX_VALUE);
		
		Deque<Min> deq = new ArrayDeque<>();
		deq.addLast(new Min(0,0));
//		visited[1] = 1;
		visited[0] = 0;

		
		while (!deq.isEmpty()) {
			Min min = deq.pollFirst();
			
			if (min.loc == n && min.cnt <= k) break;
			
			if (visited[min.loc] == k) continue;
			
			if (min.loc + min.loc/2 <= n && min.cnt + 1 <= k) {
				if (visited[min.loc+min.loc/2] > min.cnt+1) {
					visited[min.loc+min.loc/2] = Math.min(visited[min.loc+min.loc/2], min.cnt+1);
					deq.addFirst(new Min(min.loc+min.loc/2 , min.cnt+1));
				}
			}
			
			if (min.loc + 1 <= n && min.cnt + 1 <= k) {
				if (visited[min.loc+1] > min.cnt+1) {
					visited[min.loc+1] = Math.min(visited[min.loc+1], min.cnt+1);
					deq.addLast(new Min(min.loc+1,min.cnt+1));	
				}
			}
		}
		
		if (visited[n] != Integer.MAX_VALUE) {
			System.out.println("minigimbob");
		} else {
			System.out.println("water");
		}
		
	}

}
