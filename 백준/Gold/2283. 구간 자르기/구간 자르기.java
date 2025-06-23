import java.util.*;
import java.io.*;

public class Main {
    
    static class Line{
        int a;
        int b;
        Line(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Line[] line = new Line[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            line[i] = new Line(a,b);
            min = Math.min(min, a);
            max = Math.max(max, b);
        }
        
        int left = 0;
        int right = 0;
        boolean found = false;
        
        while (left <= max && right <= max) {
            int cnt = 0;
            for (Line l : line) {
                int a = Math.max(l.a, left);
                int b = Math.min(l.b, right);
                if (b > a) {
                    cnt += (b-a);    
                }
            }
            
            if (cnt < k) {
                right++;
            } else if (cnt > k) {
                left++;
                if (left == right) right++;
            } else {
                System.out.println(left + " " + right);
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("0 0");
        }
    }
}