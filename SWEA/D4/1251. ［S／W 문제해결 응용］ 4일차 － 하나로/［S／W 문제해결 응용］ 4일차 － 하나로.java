
import java.io.*;
import java.util.*;

public class Solution {
	
	static int n;
	static long x,y;
	static double answer;
	static double e;
	static long[] xLst,yLst;
	static int[] parent;
	static PriorityQueue<Edge> pq;
	
	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		Long weight;
		Edge(int start, int end, Long weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge e) {
			return Double.compare(this.weight, e.weight);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		long t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < t+1; tc++) {
			n = Integer.parseInt(br.readLine());
			
			// 좌표 입력
			xLst = new long[n];
			yLst = new long[n];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n;i++) {
				xLst[i] = Long.parseLong(st.nextToken()); 
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				yLst[i] = Long.parseLong(st.nextToken());
			}
			
			// 세금 입력
			e = Double.parseDouble(br.readLine());
			
			// 간선 입력
			pq = new PriorityQueue<>();
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					Long dist = (xLst[i] - xLst[j])*(xLst[i] - xLst[j]) + (yLst[i] - yLst[j])*(yLst[i] - yLst[j]);
					pq.add(new Edge(i,j,dist));
				}
			}
		
			parent = new int[n+1];
			for (int i = 1; i < n+1; i++) {
				parent[i] = i;
			}
			
			long answer = 0;
			int cnt = 0;
			while (!pq.isEmpty()) {
				Edge edge = pq.poll();
				if (union(edge.start, edge.end)) continue;
				answer += edge.weight;
				cnt++;
				if (cnt == n-1) {
					break;
				}
			}
			
			System.out.println("#" + tc + " " + Math.round(answer*e));
			
			
		}

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
			return false;
		}
		return true;
	}

}
