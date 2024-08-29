
import java.io.*;
import java.util.*;

public class Main {

	static int n,m;
	static int[] parent;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		parent = new int[n+1];
		for (int i = 0; i < n+1; i++) {
			parent[i] = i;
		}
		
		for (int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n+1; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					union(i,j);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int start = find(Integer.parseInt(st.nextToken()));
		boolean flag = true;
		for (int i = 1; i < m; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			if (start != find(now)) {
				System.out.println("NO");
				flag = false;
				break;
			}
		}
		
		if (flag) {
			System.out.println("YES");
		}
		
		
		

	}
	
	private static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		
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
