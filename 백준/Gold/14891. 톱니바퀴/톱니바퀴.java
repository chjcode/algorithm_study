
import java.util.*;
import java.io.*;

public class Main {
	
	static Deque<Character>[] graph;
	static int k, num, dir,answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		
		graph = new Deque[4];
		for (int i = 0; i < 4; i++) {
			String s = br.readLine();
			graph[i] = new ArrayDeque<>();
			for (int j = 0; j < 8; j++) {
				graph[i].add(s.charAt(j));
			}
		}
		
		k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken()) - 1;
			dir = Integer.parseInt(st.nextToken());
			
			
			rotateRight(num+1, -dir);
			rotateLeft(num-1, -dir);
			rotate(graph[num],dir);
		}
		
		answer = 0;
		if (graph[0].peekFirst()== '1') {
			answer += 1;
		}
		if (graph[1].peekFirst() == '1') {
			answer += 2;
		}
		if (graph[2].peekFirst() == '1') {
			answer += 4;
		}
		if (graph[3].peekFirst() == '1') {
			answer += 8;
		}
		
		System.out.println(answer);
	}
	
	private static void rotate(Deque<Character> deq, int direction) {
		if (direction == 1) {
			deq.addFirst(deq.pollLast());
		} else if (direction == -1) {
			deq.addLast(deq.pollFirst());
		}
	}
	
	private static void rotateRight(int n, int direction) {
		if (n > 3) {
			return;
		}
		if (!graph[n].toArray()[6].equals(graph[n-1].toArray()[2]) ) {
			rotateRight(n+1, -direction);
			rotate(graph[n], direction);
		}
	}
	
	
	private static void rotateLeft(int n, int direction) {
		if (n < 0) {
			return;
		}
		if (!graph[n].toArray()[2].equals(graph[n+1].toArray()[6])) {
			rotateLeft(n-1, -direction);
			rotate(graph[n], direction);
		}
	}
	
	

}
