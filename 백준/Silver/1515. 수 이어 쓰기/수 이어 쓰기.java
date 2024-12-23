import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int sLen = s.length();

        int idx = 0;
        int num = 1;
        boolean flag = false;
        while (num < 30001) {
            String temp = num + "";
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == s.charAt(idx)) {
                    idx++;
                }
                if (idx == sLen) {
                    flag = true;
                    System.out.println(num);
                    break;
                }
            }
            if (flag) break;
            num++;
        }
    }
}
