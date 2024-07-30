
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[] arr;
	static Deque<Integer> deq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		deq = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			while (!deq.isEmpty() && arr[deq.peekLast()] < arr[i]) {
				arr[deq.pollLast()] = arr[i];
			}
			
			deq.add(i);
		}
		
		
		while (!deq.isEmpty()) {
			arr[deq.poll()] = -1;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(arr[i]).append(' ');
		}
		
		System.out.println(sb);
	}

}
