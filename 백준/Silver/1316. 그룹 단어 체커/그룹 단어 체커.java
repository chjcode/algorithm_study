import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            Set<Character> set = new HashSet<>();
            boolean flag = false;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (set.contains(c)) {
                    if (s.charAt(j) != s.charAt(j-1)) {
                        flag = true;
                        break;
                    }
                } else {
                    set.add(c);
                }
            }
            
            if (!flag) cnt++;
        }
        
        System.out.println(cnt);
    }
}