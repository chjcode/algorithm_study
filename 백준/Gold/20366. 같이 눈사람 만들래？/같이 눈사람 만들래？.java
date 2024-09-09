import java.io.*;
import java.util.*;

public class Main {

	static class Sum implements Comparable<Sum>{
		int a, b, sum;
		public Sum(int a, int b, int sum) {
			this.a = a;
			this.b = b;
			this.sum = sum;
		}
		@Override
		public int compareTo(Sum o) {
			return Integer.compare(this.sum, o.sum);
		}
		public boolean isSame(Sum o) {
			return a == o.a || a == o.b || b == o.a || b == o.b;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 눈덩이 개수
		int[] snowball = new int[N];
		Sum[] sum = new Sum[N * (N-1) / 2+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) snowball[i] = Integer.parseInt(st.nextToken());
		for(int i = 0, index = 0 ; i < N ; i++) {
			for(int j = i+1 ; j < N ; j++) sum[index++] = new Sum(i, j, snowball[i]+snowball[j]);
		}
		sum[sum.length-1] = new Sum(-1, -1, Integer.MAX_VALUE);
		
		// 최악의 경우 600 c 4로 시간 복잡도가 대략 50억 정도이다.
		// 따라서 단순 조합이 아닌 투포인터로 접근해보아야 하는 문제.
		// 네개 포인터를 두어서 했더니 시간초과가 났다.. 이게 아닌가보다..
		// 합을 배열로 저장해두고 이걸 투포인터로 해볼까?
		
		Arrays.sort(sum);
		
		int left = 0;
		int right = left+1;

		int min = Integer.MAX_VALUE;
		
		while(left < right && right < N * (N-1) / 2) {
			if(sum[right].isSame(sum[left])) {
				right++;
			} else {
				min = Math.min(min, Math.abs(sum[left].sum-sum[right].sum));
				left++;
				right = left+1;
			}
		}
		System.out.print(min);
	}
}