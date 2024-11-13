import java.util.*;
import java.io.*;

public class Main {

	static int n,m;
	static List<List<Node>> crossWalk;
	static long[] dist;
	
	static class Node implements Comparable<Node> {
		int idx;
		long cost;
		Node (int idx, long cost) {
			this.idx = idx;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return Long.compare(this.cost, o.cost);
		}
	}

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		dist = new long[n+1];
		Arrays.fill(dist, Long.MAX_VALUE);
		
		crossWalk = new ArrayList<>();
		for (int i = 0; i < n+1; i++) {
			crossWalk.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			crossWalk.get(u).add(new Node(v,i));
			crossWalk.get(v).add(new Node(u,i));
		}
		
		dijkstra();
		
		System.out.println(dist[n]);
	}
	
	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1,0));
		dist[1] = 0;
		
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (now.cost > dist[now.idx]) {
				continue;
			}
			
			for (Node next : crossWalk.get(now.idx)) {
				int nextIdx = next.idx;
				long nextCost;
				if (now.cost <= next.cost) {
					nextCost = next.cost + 1;
				} else {
					long waitTime = (m - (now.cost - next.cost) % m) % m;
	                nextCost = now.cost + waitTime + 1;
				}
				
				if (nextCost < dist[nextIdx]) {
					dist[nextIdx] = nextCost;
					pq.add(new Node(nextIdx, nextCost));
				}
			}
		}
		
	}

}
