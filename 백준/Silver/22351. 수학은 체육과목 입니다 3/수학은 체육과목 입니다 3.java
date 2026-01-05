import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;
        
        String s = br.readLine();
        int n = s.length();
        
        List<Integer> lst = new ArrayList<>();
        for (int len = 1; len <= 3 && len <= n; len++) {
            if (len > 1 && s.charAt(0) == '0') continue;
            
            int a = Integer.parseInt(s.substring(0,len));
            
            if (1 <= a && a <= 999) {
                lst.add(a);
            }
        }
        
        Collections.sort(lst);
        
        for (int a : lst) {
            sb = new StringBuilder();
            int b = a;
            while (b <= 999 && sb.length() < n) {
                sb.append(b);
                
                if (sb.length() == n && sb.toString().equals(s)) {
                    System.out.println(a + " " + b);
                    return;
                }
                
                if (sb.length() > n) {
                    break;
                }
                b++;
            }
        }
        
    }
}