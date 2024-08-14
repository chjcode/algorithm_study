
import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 10;

        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            String lst = br.readLine();
            int answer = 1;
            StringBuilder sb = new StringBuilder();

            for (char l : lst.toCharArray()) {
                if (l == '(' || l == '{' || l == '[' || l == '<') {
                    sb.append(l);
                } else if (l == ')' && sb.length() > 0 && sb.charAt(sb.length() - 1) == '(') {
                    sb.deleteCharAt(sb.length() - 1);
                } else if (l == '}' && sb.length() > 0 && sb.charAt(sb.length() - 1) == '{') {
                    sb.deleteCharAt(sb.length() - 1);
                } else if (l == ']' && sb.length() > 0 && sb.charAt(sb.length() - 1) == '[') {
                    sb.deleteCharAt(sb.length() - 1);
                } else if (l == '>' && sb.length() > 0 && sb.charAt(sb.length() - 1) == '<') {
                    sb.deleteCharAt(sb.length() - 1);
                } else {
                    answer = 0;
                    break;
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
