import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        int[] graph = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(graph);
        
        int minAbs = Integer.MAX_VALUE;
        int answer = 0;
        int left = 0;
        int right = n-1;
        while (left < right) {
            int sum = graph[left] + graph[right];
            int sumAbs = Math.abs(sum);
            if (sumAbs < minAbs) {
                minAbs = sumAbs;
                answer = sum;
            }
            
            if (sum == 0) break;
            
            if (sum < 0) {
                left++;
            }else {
                right--;
            }
        }
        
        System.out.println(answer);
        
    }
}