
import java.util.*;
import java.io.*;

public class Main {
	
	static int n,answer;
	static List<Ingredient> lst;
	
	static class Ingredient{
		int s;
		int b;
		Ingredient(int s, int b) {
			this.s = s;
			this.b = b;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		lst = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			lst.add(new Ingredient(s, b));
		}
		
		answer = Integer.MAX_VALUE;
		
		checkSubset();
		
		System.out.println(answer);
	}
	
	private static void checkSubset() {
		for (int i = 1; i < (1 << n); i++) {	//모든 조합의 경우의 수가 2^n개이므로
			int totalS = 1;		// 신맛의 총 합 
			int totalB = 0;		// 쓴맛의 총 합
			for (int j = 0; j < n; j++) {	//각 자리 비교
				if ((i&(1<<j)) > 0) {	// 비교한 결과가 0보다 크면 j번째 재료가 부분집합에 포함된 것
					totalS *= lst.get(j).s;
					totalB += lst.get(j).b;
				}
			}
			answer = Math.min(answer, Math.abs(totalS-totalB));
		}
	}
	

}
