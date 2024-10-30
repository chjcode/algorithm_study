import java.util.*;
import java.io.*;

public class Main {

	static int n,d;
	static List<Node> lst;
	static int[] dp;
	
	static class Node implements Comparable<Node>{
		int start;
		int end;
		int len;
		Node(int start, int end, int len) {
			this.start = start;
			this.end = end;
			this.len = len;
		}
		@Override
		public int compareTo(Node o) {
			
			if (this.end == o.end) {
				return Integer.compare(this.len, o.len);
			}
			
			return Integer.compare(this.end, o.end);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		lst = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			
			if (end <= d && len < end - start) {
				lst.add(new Node(start,end,len));
			}
		}
		
		dp = new int[d+1];
		for (int i = 0; i < d+1; i++) {
			dp[i] = i;
		}
		
		for (int i = 0; i < d+1; i++) {
			if (i > 0) {
				dp[i] = Math.min(dp[i], dp[i-1] + 1);
			}
			
			for (Node node : lst) {
				if (node.start == i && node.end <= d) {
					dp[node.end] = Math.min(dp[node.end], dp[i] + node.len); 
				}
			}	
		}
		
		
		
//		while(!q.isEmpty()) {
//			Node node = q.poll();
//			if (dp[node.end] > dp[node.start] + node.len) {
//				int temp = dp[node.start];
//				for (int i = node.start; i < d+1; i++) {
//					if (i <= node.end) {
//						dp[i] = temp + node.len;
//					} else {
//						dp[i] = i-node.end + temp + node.len;
//					}
//				}
//			}
//		}
		
		System.out.println(dp[d]);
		
	}

}
