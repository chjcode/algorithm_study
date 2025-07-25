import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int g = Integer.parseInt(br.readLine());
        // x * x - y * y = g
        
        int left = 1;         // y : 기억 몸무게
        int right = 2;    // x : 현재 몸무게
        boolean flag = false;
        while (left < right) {
            int sub = right * right - left * left;
            
            if (sub == g) {
                sb.append(right).append("\n");
                left++;
                flag = true;
            } else if (sub < g) {
                right++;
            } else {
                left++;
            }
        }
        
        if (flag) {
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }
}