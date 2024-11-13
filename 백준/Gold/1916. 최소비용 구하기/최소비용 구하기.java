import java.util.*;
import java.io.*;

public class Main {

	static int n,m;
	static List<List<Node>> graph;
	static int[] dist;
	static boolean[] visited;
	
	static class Node implements Comparable<Node>{
		int idx;
		int cost;
		Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		visited = new boolean[n+1];
		
		graph = new ArrayList<>();
		for (int i = 0; i < n+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(new Node(v,cost));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
		
		System.out.println(dist[end]);
	}
	
	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,0));
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			
			if (visited[now.idx]) continue;
			
			visited[now.idx] = true; 
			for (Node next : graph.get(now.idx)) {
				
				// 방문하지 않았고, 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
				if (!visited[next.idx] && (dist[next.idx] > now.cost + next.cost)) {
					dist[next.idx] = now.cost + next.cost;
					pq.add(new Node(next.idx, dist[next.idx]));
				}
			}
		}
		
		
	}

}
