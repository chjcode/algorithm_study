import java.io.*;
import java.util.*;

public class Solution {
	
	static int u,v,a,b,c;
	static long answer;
	static int[] parent;
	static ArrayList<Edge> edgeList;
	
	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int weight;
		
		Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge e) {
			return this.weight - e.weight;
		}
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < t+1; tc++ ) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			
			parent = new int[u+1];
			for (int i = 1; i < u+1; i++) {
				parent[i] = i;
			}
			
			edgeList = new ArrayList<>();
			for (int i = 0; i < v;i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				
				edgeList.add(new Edge(a,b,c));
			}
			
			Collections.sort(edgeList);
			answer=  0;
			for (int i = 0; i < edgeList.size(); i++) {
				int start = edgeList.get(i).start;
				int end = edgeList.get(i).end;
				int weight = edgeList.get(i).weight;
				
				if (find(start) != find(end)) {
					answer += (long) weight;
					union(start,end);
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		
		}	
	}
	
	private static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		
		parent[x] = find(parent[x]);
		return parent[x];
	}

	private static void union(int x,int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		
		if (xRoot != yRoot) {
			parent[yRoot] = xRoot;
		}
		
	}
}

//2
//7 11
//0 1 32
//0 2 31
//0 5 60
//0 6 51
//1 2 21
//2 4 46
//2 6 25
//3 4 34
//3 5 18
//4 5 40
//4 6 51
//5 10
//0 1 5
//0 2 10
//0 3 8
//0 4 7
//1 2 5
//1 3 3
//1 4 6
//2 3 1
//2 4 3
//3 4 1