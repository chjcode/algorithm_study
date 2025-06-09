import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] snack = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            snack[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, snack[i]);
        }
        
        int left = 1;
        int right = max;
        int answer = 0;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            
            for (int i = 0; i < n; i++) {
                cnt += snack[i] / mid;
            }
            
            if (cnt >= m) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println(answer);
        
    }
}