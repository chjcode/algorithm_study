
import java.io.*;
import java.util.*;

public class Solution {

	static long n, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < t + 1; tc++) {
			n = Long.parseLong(br.readLine());
			
			cnt = 0;

			
			while (true) {
				if (n == 2) {
					break;
				}
				long x = (long) Math.sqrt(n);
				if (x * x == n) {
					cnt += 1;
					n = x;
				} else {
					cnt += (x+1) * (x+1) - n + 1;
					n = x+1;
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}

	}
}
