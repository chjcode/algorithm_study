import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);
        
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        while (right < n) {      
            int sub = arr[right] - arr[left];
            if (sub > m) {
                min = Math.min(min, sub);
                left++;
            }else if (sub < m) {
                right++;
            } else {
                min = m;
                break;
            }
        }
        
        System.out.println(min);
    }
}