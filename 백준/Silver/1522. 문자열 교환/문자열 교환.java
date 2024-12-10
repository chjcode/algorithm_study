import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int sLen = s.length();
        int aCnt = 0;
        for (int i = 0; i < sLen; i++) {
            if (s.charAt(i) == 'a') aCnt++;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < sLen; i++) {
            int bCnt = 0;
            for (int j = i; j < i+aCnt; j++) {
                if (s.charAt(j%sLen) == 'b') bCnt++;
            }
            min = Math.min(min,bCnt);
        }

        System.out.println(min);
    }
}
