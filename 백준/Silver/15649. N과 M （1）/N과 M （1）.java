
import java.util.*;
import java.io.*;

public class Main {
	
	static int n,m;
	static List<Integer> lst;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		lst = new ArrayList<>();
		permutation(0);
	}
	
	private static void permutation(int depth) {
		if (depth == m) {
			for (int i = 0 ; i < m; i++) {
				System.out.print(lst.get(i) + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 1; i < n+1; i++) {
			if (lst.contains(i)) {
				continue;
			}
			
			lst.add(i);
			permutation(depth+1);
			lst.remove(lst.size()-1);
		}
	}

}
