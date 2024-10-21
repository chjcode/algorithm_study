import java.util.*;
import java.io.*;

public class Main {

	static int k,n,cnt;
	static long answer;
	static long[] graph;
	static PriorityQueue<Long> pq;
	static List<Integer> lst;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		graph = new long[k];
		pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			graph[i] = Integer.parseInt(st.nextToken());
			pq.add(graph[i]);
		}
		
		cnt = n;
		answer = 0;
		while (cnt-- > 0) {
			answer = pq.poll();
			
			for (int i = 0; i < k; i++) {
				pq.add(graph[i] * answer);
				
				if (answer % graph[i] == 0) {
					break;
				}
			}
			
		}
		
		System.out.println(answer);
	}
	

}
