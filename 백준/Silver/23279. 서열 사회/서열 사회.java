import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            
            int[] arr = new int[p];
            
            for (int j = 0; j < p; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(arr);
            
            for (int j = 0; j < p; j++) {
                int idx = arr[j] + j + 1;
                sb.append(idx).append(" ");
            }
            sb.append("\n");
            
            
        }
        System.out.println(sb);
    }
}