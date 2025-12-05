import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        
        int rCnt = 0;
        int bCnt = 0;
        char prev = 'A';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            if (c != prev) {
                if (c == 'R') {
                    rCnt++;
                }else {
                    bCnt++;
                }
                prev = c;
            }
        }
        
        int answer = Math.min(rCnt, bCnt) + 1;
        System.out.println(answer);
        
    }
}

