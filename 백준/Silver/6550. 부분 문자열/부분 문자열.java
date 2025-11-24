import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input;
        
        
        while((input = br.readLine()) != null) {
            if (input.isEmpty()) continue;
            
            st = new StringTokenizer(input);
            String s = st.nextToken();
            String t = st.nextToken();
            
            int idx = 0;
            int cnt = 0;
            for (int i = 0; i < t.length() && idx < s.length(); i++) {
                if (s.charAt(idx) == t.charAt(i)) {
                    idx++;
                    cnt++;
                }
            }
            
            if (s.length() == cnt) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            
        }
    }
}