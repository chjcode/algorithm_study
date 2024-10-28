import java.util.*;
import java.io.*;

public class Main {

    static String s,t;
    static int n,m;
    static boolean flag;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        /**
         * 문자열의 뒤에 A를 추가한다.
         * 문자열의 뒤에 B를 추가하고 문자열을 뒤집는다.
         *
         * 문자열의 뒤에 A를 제거한다.
         * 문자열을 뒤집고 뒤에 B제거
         */

        s = br.readLine();
        t = br.readLine();
        n = s.length();
        m = t.length();

        find(0,s,t);

        if (flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

    private static void find(int depth, String s, String temp) {

        if (depth == m-n) {
            if (s.equals(temp)) {
                flag = true;
            }
            return;
        }

        // 앞이 B이면 맨앞 B제거 후 reverse
        if (temp.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < temp.length(); i++) {
                sb.append(temp.charAt(i));
            }
            find(depth+1, s,sb.reverse().toString());
        }

        if (temp.charAt(temp.length()-1) == 'A') {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < temp.length()-1; i++) {
                sb.append(temp.charAt(i));
            }
            find(depth+1, s,sb.toString());
        }
    }
}
