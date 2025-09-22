import java.util.*;
import java.io.*;

public class Main {
    
    static int n,k, now, cnt;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        arr = new int[n];
        visited = new boolean[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        now = 500;
        cnt = 0;
        dfs(0);
        
        System.out.println(cnt);
    }
    
    private static void dfs(int depth) {
        if (depth == n) {
            cnt++;
            return;
        }
        
        for (int i = 0; i < n; i++) {
            
            if (visited[i]) continue;
            
            if (now + arr[i] - k >= 500) {
                now = now + arr[i] - k;
                visited[i] = true;
                dfs(depth+1);
                now = now - arr[i] + k;
                visited[i] = false;
            }
        }
    }
}