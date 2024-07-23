import java.util.*;
import java.io.*;

public class Main {
	static List<Integer> file,file1,file2;
	static int t,k; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		t = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < t; tc++) {
			k = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			PriorityQueue<Long> pq = new PriorityQueue<>();
			for (int i = 0; i < k; i++) {
				pq.add(Long.parseLong(st.nextToken()));
			}
			long sum = 0L;
			while (pq.size() != 1) {
				long a = pq.remove();
				long b= pq.remove();
				sum += (a+b);
				pq.add(a + b);
				
			}
			System.out.println(sum);
		}
		
	}

}
