
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < t+1; tc++) {
			int answer = 1;
			String s = br.readLine();
			int len = s.length();
			
			Deque<Character> deq = new ArrayDeque<>();

			for (int i = 0; i < len/2; i++) {
				deq.addLast(s.charAt(i));
			}	
			
			if (len % 2 == 0) {
				for (int i = len/2;i<len;i++) {
					if (s.charAt(i) != deq.pollLast()) {
						answer = 0;
						break;
					}
				}
			} else {
				for (int i = len/2+1;i<len;i++) {
					if(s.charAt(i) != deq.pollLast()) {
						answer = 0;
						break;
					}
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}

}
