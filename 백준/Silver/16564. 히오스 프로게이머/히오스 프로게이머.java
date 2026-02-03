import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int minNum = Integer.MAX_VALUE;
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            minNum = Math.min(minNum, arr[i]);
        }
        
        
        int left = minNum;
        int right = minNum+k;
        int result = minNum;
        while (left <= right) {
            int mid = (left + right) / 2;
            
            long cnt = 0;
            for (int i = 0; i < n; i++) {
                if (mid > arr[i]) {
                    cnt += (mid-arr[i]);
                    if (cnt > k) break;
                }
            }
            
            if (cnt <= k) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(result);
    }
}