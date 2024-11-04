import java.util.*;
import java.io.*;

public class Main {

	static int n,m,a,b,c;
	static List<List<Node>> graph;
	static PriorityQueue<Node> pq;
	static int[] dist;
	static boolean[] visited;
	
	static class Node implements Comparable<Node> {
		int m;
		int c;
		Node(int m, int c) {
			this.m = m;
			this.c = c;
		}
		
		@Override
		public int compareTo(Node n) {
			return Integer.compare(this.c, n.c);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i < n+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node(b,c));
			graph.get(b).add(new Node(a,c));
		}
		
		dist = new int[n+1];
		visited = new boolean[n+1];
		for (int i = 0; i < n+1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		pq = new PriorityQueue<>();
		pq.add(new Node(1,0));
		dist[1] = 0;
		
		while (!pq.isEmpty()) {
			Node now = pq.poll();

			if (visited[now.m]) continue;
			
			visited[now.m] = true;
			
			for (int i = 0; i < graph.get(now.m).size(); i++) {
				Node next = graph.get(now.m).get(i);
				if (dist[next.m] > dist[now.m] + next.c) {
					dist[next.m]= dist[now.m] + next.c;
					pq.add(new Node(next.m, dist[next.m]));
				}
			}
		}
		
		System.out.println(dist[n]);
	}

}
