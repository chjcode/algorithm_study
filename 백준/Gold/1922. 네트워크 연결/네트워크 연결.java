import java.util.*;
import java.io.*;

public class Main {
	
	static int n,m,a,b,c,answer;
	static int[] parent;
	static ArrayList<Edge> edgeList;
	
	static class Edge implements Comparable<Edge>{
		int a;
		int b;
		int c;
		
		Edge(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Edge o) {	
			return this.c - o.c;
		}
		
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		edgeList = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			edgeList.add(new Edge(a,b,c));
			
		}
		
		// make-set i : 자신의 부모를 자신으로하여 대표자가 되도록 설정
		parent = new int[n+1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		
		// 크루스칼 알고리즘의 핵심은 가장 작은 가중치의 간선부터 차례대로 선택해 나가는 것이다.
		// 현재 선택이 최적임을 보장하기 위해 정렬을 해야 한다.
		Collections.sort(edgeList);
		
		answer = 0;
		for (int i = 0; i < edgeList.size(); i++) {
			Edge edge = edgeList.get(i);
			
			if (find(edge.a) != find(edge.b)) {
				answer += edge.c;
				union(edge.a, edge.b);
			}
		}
		
		System.out.println(answer);
		
	}
	
	private static int find(int x) {
		// 자신이 자신의 부모라면 루트노드이고 집합의 대표자가 된다.
		if (x == parent[x]) {
			return x;
		}
		
		// find(parent[x])를 통해 최상위 부모를 찾은 뒤, parent[x]에 자신의 최상위 부모값을
		// 저장함으로써 각 노드가 자신의 최상위 부모를 직접 가리키도록 한다.
		parent[x] = find(parent[x]);
		
		return parent[x];
	}
	
	private static void union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		
		// 두 집합의 대표자가 같으면 이미 같은 집합이므로 다른 집합일 때만 두 집합 합치기
		if (xRoot != yRoot) {
			parent[yRoot] = xRoot;	// aRoot에 bRoot를 흡수 : 두 집합 합치기
		}
	}

}
