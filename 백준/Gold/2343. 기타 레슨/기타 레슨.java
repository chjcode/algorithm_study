import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        long sum = 0;
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }
        
        long left = max;
        long right = sum;
        long result = sum;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            int cnt = 1;
            long blueSum = 0;    // 블루레이에 담긴 영상 길이
            
            for (int i = 0; i < n; i++) {
                if (mid < blueSum + arr[i]) {
                    cnt++;
                    blueSum = arr[i];
                } else {
                    blueSum += arr[i];
                }
            }
            
            if (cnt <= m) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        System.out.println(result);
    }
}

