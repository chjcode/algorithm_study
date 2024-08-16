
import java.util.*;
import java.io.*;

public class Solution {
	
	static int n,m,answer;
	static List<Ingredient> lst;
	
	static class Ingredient{
		int a;
		int b;
		Ingredient(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < t+1; tc++) {
			// n,m 입력 받기
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			// 동시에 들어가면 안되는 재료 입력 받기
			lst = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				lst.add(new Ingredient(a,b));
			}
			
			// 모든 부분 집합 확인
			answer = 0;
			checkSubset();
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	private static void checkSubset() {
		for (int i = 0; i < (1<<n);i++) {	//2^n-1개의 부분집합
			boolean flag = true;
			for (Ingredient ingre : lst) {
				if ((i&(1<<ingre.a)) != 0 && (i&(1<<ingre.b)) != 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				answer++;
			}
		}
	}
}
