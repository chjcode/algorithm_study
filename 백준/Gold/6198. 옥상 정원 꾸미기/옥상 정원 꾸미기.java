import java.util.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    int[] graph = new int[n];
	    
	    long answer = 0;
	    Deque<Integer> deq = new ArrayDeque<>(); 
	    for (int i = 0; i < n; i++) {
	        int num = Integer.parseInt(br.readLine());
	        graph[i] = num;
	        
	        while (!deq.isEmpty() && deq.peekLast() <= graph[i]) {
	            deq.pollLast();
	        }
	        
	        answer += deq.size();
	        deq.addLast(graph[i]);
	    }
	    
	    System.out.println(answer);
	}
	
}
