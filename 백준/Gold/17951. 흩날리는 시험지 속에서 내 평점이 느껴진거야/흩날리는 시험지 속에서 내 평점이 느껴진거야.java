import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        
        int total = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }
        
        int left = 0;
        int right = total;
        int result = 0;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            
            int cnt = 0;
            int sum = 0;
            
            for (int i = 0; i < n; i++) {
                sum += arr[i];
                if (sum >= mid) {
                    cnt++;
                    sum = 0;
                }
            }
            
            if (cnt >= k) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(result);
    }
}