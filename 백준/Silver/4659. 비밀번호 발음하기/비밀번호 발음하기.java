import java.util.*;
import java.io.*;


public class Main {
    static char[] mo = {'a','e','i','o','u'};
    static String moS = "aeiou";
    public static void main(String[] args) throws Exception{
        /**
         * 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
         * 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
         * 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            String s = br.readLine();
            if (s.equals("end")) break;

            if (check(s)) {
                System.out.println("<" + s + "> is acceptable.");
            } else {
                System.out.println("<" + s + "> is not acceptable.");
            }
        }
    }

    private static boolean check(String s) {
        boolean hasMo = false; //모음이 하나 이상 있는지 체크
        int cntBeforeMo = 0; // 모음 연속 체크
        int cntBeforeJa = 0; // 자음 연속 체크
        char beforeChar = 'e';
        for (int i = 0; i < s.length(); i++) {
            // 모음 체크
            boolean nowMo = false;
            for (int j = 0; j < 5; j++) {
                if (s.charAt(i) == mo[j]) {
                    hasMo = true;
                    nowMo = true;
                    break;
                }
            }
            // 연속 체크
            if (nowMo) {
                cntBeforeMo++;
                cntBeforeJa = 0;
            } else {
                cntBeforeJa++;
                cntBeforeMo = 0;
            }

            if (cntBeforeMo >= 3 || cntBeforeJa >= 3) {
                return false;
            }

            if (s.charAt(i) == beforeChar && beforeChar != 'e' && beforeChar != 'o') {
                return false;
            }

            beforeChar = s.charAt(i);
        }

        if (hasMo) {
            return true;
        } else {
            return false;
        }
    }
}
