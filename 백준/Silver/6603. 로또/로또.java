import java.util.*;
import java.io.*;

public class Main {
    
    static int k;
    static int[] arr, pick;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        
        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            
            if (k == 0) break;
            
            arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            pick = new int[6];
            dfs(0,0);
            System.out.println();
        }
        
    }
    
    private static void dfs(int start, int depth) {
        if (depth == 6) {
            for (int i = 0; i < 5; i++) {
                System.out.print(pick[i] +  " ");
            }
            System.out.println(pick[5]);
            return;
        }
        
        for (int i = start; i < k; i++) {
            pick[depth] = arr[i];
            dfs(i+1, depth+1);
        }
    }
}