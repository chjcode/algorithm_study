import java.util.*;
import java.io.*;

public class Main {
	
	static int n,m;
	static int[] cnt;
	static List<List<Integer>> lst = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		cnt = new int[n+1];
		
		for (int i = 0; i < n+1; i++) {
			lst.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			lst.get(a).add(b);
			cnt[b]++;
		}
		
		topologicalSort();
		
		System.out.println(sb.toString());
	}
	
	private static void topologicalSort() {
		Deque<Integer> deq = new ArrayDeque<>();
		
		for(int i = 1; i < n+1; i++) {
			if (cnt[i] == 0) {
				deq.addLast(i);
			}
		}
		
		while(!deq.isEmpty()) {
			int node = deq.pollFirst();
			
			sb.append(node).append(" ");
			
			for (int i = 0; i < lst.get(node).size(); i++) {
				cnt[lst.get(node).get(i)]--;
				
				if (cnt[lst.get(node).get(i)] == 0) {
					deq.addLast(lst.get(node).get(i));
				}
			}
			
		}
	}

}
