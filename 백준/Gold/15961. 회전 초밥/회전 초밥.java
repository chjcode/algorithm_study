import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder output = new StringBuilder();

	static int read() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	public static void main(String[] args) throws Exception {
		int N = read(); // 초밥 벨트에 놓인 접시의 수
		int d = read(); // 초밥의 가짓수
		int k = read(); // 연속해서 먹는 접시의 수
		int c = read(); // 쿠폰 번호
		
		int[] sushiNum = new int[N+k];
		int[] sushiCnt = new int[d+1];
		for(int i = 0 ; i < N ; i++) sushiNum[i] = read();
		for(int i = N ; i < N+k ; i++) sushiNum[i] = sushiNum[i-N];
		
		sushiCnt[c]++;
		int cnt = 1;
		
		// 각 초밥마다 개수 count
		for(int i = 0 ; i < k ; i++) {
			int n = sushiCnt[sushiNum[i]]++;
			if(n == 0) cnt++;
		}
		
		int max = 0;
		// N번 슬라이딩 윈도우
		for(int sw = 0 ; sw < N ; sw++) {
			max = Math.max(max, cnt);
			// 첫번째 원소 빼고 다음 원소 넣기
			int first = --sushiCnt[sushiNum[sw]];
			int last = sushiCnt[sushiNum[sw+k]]++;
			if(first == 0) cnt--;
			if(last == 0) cnt++;
		}
		System.out.print(max);
	}
}
