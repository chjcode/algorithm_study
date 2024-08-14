
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
		combination(1,0);
		
		
	}
	
	private static void combination(int start, int cnt) {
		if (cnt == m) {
			for (int i = 0; i < cnt; i++) {
				System.out.print(lst.get(i) + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i < n+1; i++) {
			if (lst.contains(i)) {
				continue;
			}
			
			lst.add(i);
			combination(i, cnt+1);
			lst.remove(lst.size()-1);
		}
	}

}
