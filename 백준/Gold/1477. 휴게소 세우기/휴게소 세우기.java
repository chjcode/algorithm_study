import java.util.*;
import java.io.*;

public class Main {
    
    static int n,m,l;
    static int[] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        
        arr = new int[n+2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[n+1] = l;
        Arrays.sort(arr);
        
        int left = 1;
        int right = l;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            
            int cnt = 0;
            for (int i = 1; i < n+2; i++) {
                int dist = arr[i] - arr[i-1];
                cnt += (dist - 1) / mid;
            }
            
            if (cnt > m) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }
        
        System.out.println(answer);
    }
}