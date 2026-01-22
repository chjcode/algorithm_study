import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[n+1];
        
        st = new StringTokenizer(br.readLine());
        int now = 0;
        int max = 0;
        
        for (int i = 0; i < 2*n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            
            if (!visited[temp]) {
                visited[temp] = true;
                now++;
                max = Math.max(max, now);
            } else {
                visited[temp] = false;
                now--;
            }
            
        }
        
        System.out.println(max);
        
    }
}