import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for (int i = 1; i < (1<<n); i++) {
            int sum = 0;
            
            for (int j = 0; j < n; j++) {
                if ((i&(1<<j)) != 0) {
                    sum += arr[j];
                }
            }
            
            if (sum == s) {
                answer++;
            }
            
        }
        System.out.println(answer);
    }
}