import java.util.*;
import java.io.*;

public class Main {
    static int wLen, sLen;
    static String w,s;
    static int[] wCnt = new int[52];
    static int[] nowCnt = new int[52];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        wLen = Integer.parseInt(st.nextToken());
        sLen = Integer.parseInt(st.nextToken());

        w = br.readLine();
        s = br.readLine();

        for (char c : w.toCharArray()) {
            addCount(wCnt, c, 1);
        }

        for (int i = 0; i < wLen; i++) {
            addCount(nowCnt, s.charAt(i), 1);
        }

        int answer = 0;
        for (int i = 0; i <= sLen - wLen; i++) {
            if (Arrays.equals(wCnt, nowCnt)) {
                answer++;
            }

            if (i + wLen < sLen) {
                addCount(nowCnt, s.charAt(i), -1);
                addCount(nowCnt, s.charAt(i+wLen), 1);
            }
        }
        System.out.println(answer);
    }

    static void addCount(int[] count, char c, int value) {
        if ('a' <= c && c <= 'z') {
            count[c-'a'] += value;
        } else if ('A' <= c && c <= 'Z') {
            count[c-'A' + 26] += value;
        }
    }
}
