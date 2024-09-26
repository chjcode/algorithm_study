import java.util.*;
import java.io.*;

public class Main {

	static int n,mp,mf,ms,mv;
	static int[][] graph;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		mp = Integer.parseInt(st.nextToken());
		mf = Integer.parseInt(st.nextToken());
		ms = Integer.parseInt(st.nextToken());
		mv = Integer.parseInt(st.nextToken());
		
		graph = new int[n][5];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = Integer.MAX_VALUE;
		List<Integer> combi = new ArrayList<>();
		for (int i = 0; i < (1<<n); i++) {
			List<Integer> lst = new ArrayList<>();
			
			for (int j = 0; j < n; j++) {
				if ((i&(1<<j)) != 0) {
					lst.add(j);
				}
			}
			
			int p = 0;
			int f = 0;
			int s = 0;
			int v = 0;
			int c = 0;
			for (int idx : lst) {
				p += graph[idx][0];
				f += graph[idx][1];
				s += graph[idx][2];
				v += graph[idx][3];
				c += graph[idx][4];
			}
			
			if (p >= mp && f >= mf && s >= ms && v >= mv) {
				if (c < answer) {
					answer = c;
					combi = new ArrayList<>(lst);
				}else if (c == answer) {
					if (check(lst,combi)) {
						combi = new ArrayList<>(lst);
					}
				}
			}
		}
		
		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
			for (int idx : combi) {
				System.out.print((idx + 1) + " ");
			}
			System.out.println();
		}
	}
	
	private static boolean check(List<Integer> lst1, List<Integer> lst2) {
		int size = Math.min(lst1.size(), lst2.size());
		for (int i = 0; i < size; i++) {
			if (lst1.get(i) < lst2.get(i)) {
				return true;
			} else if (lst1.get(i) > lst2.get(i)) {
				return false;
			}
		}
		
		return lst1.size() < lst2.size();
	}
}
