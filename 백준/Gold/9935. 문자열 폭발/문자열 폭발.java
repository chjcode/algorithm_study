import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String s = br.readLine();
		int sLen = s.length();
		String bomb = br.readLine();
		int bLen = bomb.length();
		
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < sLen; i++) {
			stack.push(s.charAt(i));
			
			if (stack.size() >= bLen) {
				
				boolean flag = true;
				for (int j = 0; j < bLen; j++) {
					if (stack.get(stack.size() - bLen + j) != bomb.charAt(j)) {
						flag = false;
						break;
					}
				}
				
				if (flag) {
					for (int j = 0; j < bLen; j++) {
						stack.pop();
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		if (stack.isEmpty()) {
			System.out.println("FRULA");
		} else {
			for (char c : stack) {
				sb.append(c);
			}
		}
		
		System.out.println(sb);
		
	}

}
