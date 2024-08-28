
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int n,m,a,b,order;
	static int[] parent;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < t+1; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			sb = new StringBuilder();
			
			parent = new int[n+1];
			for (int i = 1; i < n+1; i++) {
				parent[i] = i;
			}
			
			for (int i = 0; i < m;i++) {
				st = new StringTokenizer(br.readLine());
				order = Integer.parseInt(st.nextToken());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				
				if (order == 1) {
					if(find(a)==find(b)) {
						sb.append(1);
					}else {
						sb.append(0);
					}
				}else if (order == 0) {
					union(a,b);
				}
			}
			
			System.out.println("#" + tc + " " + sb.toString());
		}
	}
	
	private static int find(int x) {
		if (parent[x] == x) return x;
		
		parent[x] = find(parent[x]);
		return parent[x];
	}
	
	private static void union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		
		if (xRoot != yRoot) {
			parent[yRoot] = xRoot;
		}
	}

}
