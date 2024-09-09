import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, start, end;
	static ArrayList<Edge>[] bridge;
	static class Edge implements Comparable<Edge>{
		int to;
		long cost;
		public Edge(int to, long cost) {
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			return Long.compare(o.cost, cost);
		}
	}
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		bridge = new ArrayList[N];
		for(int i = 0 ; i < N ; i++) bridge[i] = new ArrayList<>();
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			long limit = Long.parseLong(st.nextToken());
			bridge[from].add(new Edge(to, limit));
			bridge[to].add(new Edge(from, limit));
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken())-1;
		end = Integer.parseInt(st.nextToken())-1;
		
		// bfs
		long maxWeight = Long.MIN_VALUE;
		
		PriorityQueue<Edge> q = new PriorityQueue<>();
		q.offer(new Edge(start, Long.MAX_VALUE));
		boolean[] visited = new boolean[N];
		
		while(!q.isEmpty()) {
			Edge now = q.poll();
			if(visited[now.to]) continue;
			visited[now.to] = true;
			if(now.to == end) {
				maxWeight = Math.max(maxWeight, now.cost);
			}
			for(Edge e : bridge[now.to]) {
				q.offer(new Edge(e.to, Math.min(now.cost, e.cost)));
			}
		}
		System.out.println(maxWeight);
	}
}