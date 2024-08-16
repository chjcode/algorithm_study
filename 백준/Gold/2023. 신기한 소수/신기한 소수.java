
import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int[] start = {2,3,5,7};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < 4; i++) {
			findPrime(start[i], 1);
		}
		

	}
	
	private static void findPrime(int num, int len) {
		// n자리 수가 되면 출력
		if (len == n) {
			System.out.println(num);
			return;
		}
		
		for (int i = 1; i < 10; i+=2) {
			int nextNum = num * 10 + i;
			if (isPrime(nextNum)) {
				findPrime(nextNum,len+1);
			}
		}
		return;
	}
	
	private static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}
		
		for (int i = 2; i < Math.sqrt(num)+1; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
