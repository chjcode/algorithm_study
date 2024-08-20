
import java.io.*;
import java.util.*;

public class Main {
	
	static int n,l;
	static int[] h;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		
		h = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(h);
		
		for (int i = 0; i < n; i++) {
			if (h[i] <= l) {
				l++;
			} else {
				break;
			}
		}
		
		System.out.println(l);
	}

}
