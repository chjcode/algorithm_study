import java.util.*;
import java.io.*;

public class Main {
    
    static class Rule {
        int a,b,c;
        Rule (int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        Rule[] rules = new Rule[k];
        
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            rules[i] = new Rule(a,b,c);
        }
        
        int left = 0;
        int right = n;
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            long cnt = 0;
            for (Rule rule : rules) {
                if (mid < rule.a) continue;
                
                cnt += ((Math.min(mid, rule.b) - rule.a) / rule.c) + 1;
                
                if (cnt >= d) break;
            }
            
            if (cnt >= d) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        System.out.println(result);
        
    }
}