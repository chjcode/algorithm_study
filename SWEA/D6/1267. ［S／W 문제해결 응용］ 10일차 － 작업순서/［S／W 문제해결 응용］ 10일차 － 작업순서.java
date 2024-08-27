
import java.io.*;
import java.util.*;

public class Solution {
	
	static int v,e;
	static List<List<Integer>> lst;
	static int[] cnt;
	static StringBuilder sb;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc < 11; tc++) {
			st = new StringTokenizer(br.readLine());
			sb = new StringBuilder();
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			
			lst = new ArrayList<>();
			for (int i = 0; i < v+1; i++) {
				lst.add(new ArrayList<>());
			}
			
			cnt = new int[v+1];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < e; i++) {				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				lst.get(a).add(b);
				cnt[b]++;
			}
			
			sort();
			
			System.out.println("#" + tc + " " + sb.toString());
		}
	}
	
	private static void sort() {
		Deque<Integer> deq = new ArrayDeque<>();
		
		for (int i = 1; i < v+1; i++) {
			if (cnt[i] == 0) {
				deq.addLast(i);
			}
		}
		
		while(!deq.isEmpty()) {
			int node = deq.pollFirst();
			sb.append(node).append(" ");
			for (int i = 0; i < lst.get(node).size();i++) {
				cnt[lst.get(node).get(i)]--;
				if (cnt[lst.get(node).get(i)] == 0) {
					deq.addLast(lst.get(node).get(i));
				}
			}
		}
		
	}
}
