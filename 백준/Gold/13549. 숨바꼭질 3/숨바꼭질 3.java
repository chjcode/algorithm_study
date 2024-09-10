import java.util.*;
import java.io.*;

public class Main {

	static int n,k, len;
	static int[] graph;
	static int[] visited;
	
	static class Point{
		int x;
		int time;
		Point (int x, int time) {
			this.x = x;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		len = Math.max(n, k) * 2 + 1;
		visited = new int[len];
		Arrays.fill(visited, Integer.MAX_VALUE);
		
		System.out.println(bfs());
		

	}
	
	private static int bfs() {
		Deque<Point> deq = new ArrayDeque<>();
		deq.addLast(new Point(n,0));
		visited[n] = 0;
		
		while(!deq.isEmpty()) {
			Point point = deq.pollFirst();
			
			if (point.x == k) {
				return point.time;
			}
			
			if (0 <= point.x * 2 && point.x * 2 < len && visited[point.x*2] > visited[point.x]) {
				visited[point.x * 2] = point.time;
				deq.addFirst(new Point(point.x*2,point.time));
			}
			
			if (point.x+1 < len && visited[point.x+1] > visited[point.x]+1) {
				visited[point.x+1] = point.time+1;
				deq.addLast(new Point(point.x+1, point.time + 1));
			}
			
			if (point.x-1 >= 0 && visited[point.x-1] > visited[point.x]+1) {
				visited[point.x-1] = point.time+1;
				deq.addLast(new Point(point.x-1, point.time+1));
			}
		}
		
		return -1;
	}

}
