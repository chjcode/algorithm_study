import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    static int n,m;
    static int[] a,b;
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < t; tc++) {
		    st = new StringTokenizer(br.readLine());
    		n = Integer.parseInt(st.nextToken());
    		m = Integer.parseInt(st.nextToken());
    		
    		st = new StringTokenizer(br.readLine());
    		a = new int[n];
    		for (int i = 0; i < n; i++) {
    		    a[i] = Integer.parseInt(st.nextToken());
    		}
            
            st = new StringTokenizer(br.readLine());
    		b = new int[m];
    		for (int i = 0; i < m; i++) {
    		    b[i] = Integer.parseInt(st.nextToken());
    		}
		    
		    Arrays.sort(b);
		    
		    int answer = 0;
    		for (int i = 0; i < n; i++) {
    		    int left = 0;
    		    int right = m-1;
    		    int result = -1;
    		    while (left <= right) {
    		        int mid = (left + right) / 2;
    		        if (b[mid] < a[i]) {
    		            result = Math.max(mid,result);
    		            left = mid + 1;
    		        } else {
    		            right = mid - 1;
    		        }
    		    }
    		    
    		    if (result > -1) {
    		        answer += result+1;
    		    }
    		}
		    
		    System.out.println(answer);
		}
    		
		
		
		
// 		// 8 1 7 3 1
// 		// 1 3 6 
        
        // 3, 0,  3, 
        
// 		left = 0
// 		right = 2
// 		mid = 1
// 		result = 1
// 		--
// 		left = 2
// 		right = 2
// 		mid = 2
// 		result = 2
// 		answer = 
		
		
	}
}
