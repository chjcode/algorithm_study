import java.util.*;
import java.io.*;

class Main
{
    static int n,s;
    static long[] graph;
    
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        

        graph = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            graph[i] = Long.parseLong(st.nextToken());
        }

        
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        long now = 0;
        while (true) {
            
            if (now >= s) {
                min = Math.min(min, right-left);
                now -= graph[left++];
                // System.out.println("left : " + left + " right : " + right + " now : " + now + " min : " + min);
            } else if (right == n){
                break;
                
            } else {
                
                now += graph[right++];
                // System.out.println("left : " + left + " right : " + right + " now : " + now + " min : " + min);
            }
            
        }
        
        if (min == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
	}
	
}
