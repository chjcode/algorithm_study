import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] jewels = new int[m];
        int max = 0;
        for (int i = 0; i < m; i++) {
            jewels[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, jewels[i]);
        }
        
        int left = 1;
        int right = max;
        int result = -1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            long cnt = 0;
            
            for (int jewel : jewels) {
                cnt += jewel / mid;
                if (jewel % mid != 0) cnt++;
                if (cnt > n) break;
            }
            
            if (cnt <= n) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        System.out.println(result);
        
        
    }
}