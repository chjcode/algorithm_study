
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
            Deque<Character> deq = new ArrayDeque<>();

            for (char l : lst.toCharArray()) {
                if (l == '(' || l == '{' || l == '[' || l == '<') {
                	deq.addLast(l);
                } else if (l == ')' && deq.peekLast() == '(') {
                	deq.pollLast();
                } else if (l == '}' && deq.peekLast() == '{') {
                	deq.pollLast();
                } else if (l == ']' && deq.peekLast() == '[') {
                	deq.pollLast();
                } else if (l == '>' && deq.peekLast() == '<') {
                	deq.pollLast();
                } else {
                    answer = 0;
                    break;
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
