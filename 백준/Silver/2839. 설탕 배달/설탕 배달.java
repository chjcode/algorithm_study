
import java.io.*;
import java.util.*;

public class Main {

	static int n,answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		answer = n/5;
		n %= 5;
		
		if (n == 1) {
			if (answer > 0) {
				answer += 1;	// 5봉지 -1, 3봉지 +2
			}
			else {
				answer = -1;
			}
		} else if (n == 2) {
			if (answer > 1) {
				answer += 2;	// 5봉지 -2, 3봉지 +4
			}
			else {
				answer = -1;
			}
		} else if (n == 3) {
			answer += 1;
		} else if (n == 4) {
			if (answer > 0) {
				answer += 2;	// 5봉지 -1, 3봉지 +3
			}
			else {
				answer = -1;
			}
		}
		
		System.out.println(answer);
		
	}

}
