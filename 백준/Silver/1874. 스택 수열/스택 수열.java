import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        
        int high = 1;
        int idx = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            boolean flag = false;
            
            while (high <= num) {
                stack.add(high);
                high++;
                idx++;
                sb.append('+').append('\n');
            }
            
            
            while(!stack.isEmpty()) {
                int temp = stack.pop();
                
                if (temp == num) {
                    sb.append('-').append('\n');
                    flag = true;
                    break;
                }
            }
            
            if (!flag) {
                sb = new StringBuilder();
                sb.append("NO");
                break;
            }
            
        }
        
        System.out.println(sb.toString());
        
        
    }
}