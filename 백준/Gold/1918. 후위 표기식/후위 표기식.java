

import java.util.*;
import java.io.*;

public class Main {
	
	//stack1 : 
	//stack2 : -
	// print : abc*+D
	/**
	 * 1. 일단 sb에 문자는 넣는다.
	 * 2. 덧셈이나 뺄셈 나오면 스택에 넣는다.
	 * 3. 곱셈 나오면 곱셈 sb에 넣고 덧셈이나 뺄셈 넣기
	 * 4. 곱셈이나 나눈셈 나오고 나면 다시 문자부터 sb에 넣기
	 */
	
	static Deque<Character> stack;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		stack = new ArrayDeque<>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				sb.append(c);
			} else {
				if (c == '(') {
					stack.addLast(c);
				} else if (c == '*' || c == '/') {
					while (!stack.isEmpty() && (stack.getLast() == '*' || stack.getLast() == '/')) {
						sb.append(stack.removeLast());
					}
					stack.addLast(c);
				} else if (c == '+' || c == '-') {
					while (!stack.isEmpty() && stack.getLast() != '(') {
						sb.append(stack.removeLast());
					}
					stack.addLast(c);
				} else if (c == ')') {
					while (!stack.isEmpty() && stack.getLast() != '(') {
						sb.append(stack.removeLast());
					}

					stack.removeLast();	
				}
			}
		
		}
		
		while (!stack.isEmpty()) {
			sb.append(stack.removeLast());
		}
		
		System.out.println(sb.toString());
		
	}
}
