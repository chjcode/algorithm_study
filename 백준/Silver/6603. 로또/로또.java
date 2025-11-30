import java.util.*;
import java.io.*;

public class Main {
    
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        while (true) {
            st = new StringTokenizer(br.readLine());
        
            int k = Integer.parseInt(st.nextToken());   
            if (k == 0) {
                break;
            }
            
            int[] s = new int[k];
            for (int i = 0; i < k; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }

            int[] arr = new int[6];
            dfs(0,0,k,s,new int[6]);
            sb.append("\n");
            
        }
        System.out.println(sb.toString());
        
    }
    
    private static void dfs(int depth, int start, int k, int[] s, int[] arr) {
        if (depth == 6) {
            for (int a : arr) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = start; i < k; i++) {
            arr[depth] = s[i];
            dfs(depth+1, i+1, k, s, arr);
        }
        
    }
}