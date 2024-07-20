
import java.io.*;
import java.util.*;

public class Main {
    static int n,k;
    static String num;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        num = br.readLine();
        sb = new StringBuilder();

        makeLargestNumber();
        System.out.println(sb.toString());

    }
    public static void makeLargestNumber() {
        for (int i = 0; i < n; i++){
            char nowNum = num.charAt(i);
            //현재 숫자가 이전 숫자들보다 큰 경우, 이전 숫자들 제거
            while(k > 0 && sb.length() > 0 && sb.charAt(sb.length()-1) < nowNum){
                sb.deleteCharAt(sb.length() -1);
                k--;
            }
            sb.append(nowNum);
        }
        if (k > 0){
            sb.delete(sb.length()-k, sb.length());
        }
    }
}
