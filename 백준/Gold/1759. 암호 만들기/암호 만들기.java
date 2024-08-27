
import java.io.*;
import java.util.*;

public class Main {
	
	static int l,c;
	static char[] alpha,lst;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		alpha = new char[c];
		for (int i = 0; i < c; i++) {
			alpha[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(alpha);
		lst = new char[l];
		visited = new boolean[c];
		combination(0,0);
	}
	
	private static void combination(int start, int cnt) {
		if (cnt == l) {
			int cntIaeou = 0;
			int cntElse = 0;
			for (int i = 0; i < l; i++) {
				if (iaeou(lst[i])) {
					cntIaeou++;
				} else {
					cntElse++;
				}
			}
			if (cntIaeou >= 1 && cntElse >= 2) {
				for (int i = 0; i < l;i++) {
					System.out.print(lst[i]);
				}
				System.out.println();	
			}
			return;
		}
		
		for (int i = start; i < c; i++) {
			lst[cnt] = alpha[i];
			combination(i+1,cnt+1);
		}
	}
	
	private static boolean iaeou(char ch) {
		return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o'|| ch =='u';
	}
}
