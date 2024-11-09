import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //문자열 중 사전순으로 가장 빠른것  = 가장 작은 수
        String s = br.readLine();
        //1개수 세기
        //0개수 세기
        // 1은 앞에서부터 제거
        // 0은 뒤에서 부터 제거

        int cntZero = 0;
        int cntOne = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0'){
                cntZero++;
            } else {
                cntOne++;
            }
        }

        int tanosZero = cntZero/2;
        int tanosOne = cntOne/2;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (tanosOne > 0) {
                    tanosOne--;
                } else {
                    sb.append('1');
                }
            } else {
                if (tanosZero > 0) {
                    sb.append('0');
                    tanosZero--;
                }
            }
        }

        System.out.println(sb);
    }


}