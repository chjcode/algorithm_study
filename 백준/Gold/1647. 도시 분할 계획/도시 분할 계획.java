import java.util.*;
import java.io.*;

public class Main {
	
	static int n,m,cnt,max;
	static int[] parent;
	
	static class Node implements Comparable<Node>{
		int u;
		int v;
		int cost;
		Node (int u, int v, int cost) {
			this.u = u;
			this.v = v;
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
		
		// mst 하고 젤 큰 길 하나 삭제
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		parent = new int[n+1];
		for (int i = 1; i < n+1; i++) {
			parent[i] = i;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			pq.add(new Node(u,v,cost));
		}
		
		max = 0;
		cnt = 0;
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			
			
			if (union(node.u, node.v)) {
				cnt += node.cost;
				max = Math.max(max, node.cost);
			}
		};
		
		System.out.println(cnt-max);
	}
	
	private static int find(int x) {
		if (x == parent[x]) return x;
		
		parent[x] = find(parent[x]);
		
		return parent[x];
	}
	
	private static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		
		if (xRoot != yRoot) {
			parent[yRoot] = xRoot;
			return true;
		}
		return false;
	}

}
