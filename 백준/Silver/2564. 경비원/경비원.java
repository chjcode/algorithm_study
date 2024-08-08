
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int store = Integer.parseInt(br.readLine());
		int[] storeArr = new int[store];
		
		for (int s = 0; s < store; s++) {
			st = new StringTokenizer(br.readLine());
			
			int dir = Integer.parseInt(st.nextToken());	// 방향
			int loc = Integer.parseInt(st.nextToken());	// 위치
			
			storeArr[s] = findDist(dir,loc);
		}
		
		st = new StringTokenizer(br.readLine());
		int dongDir = Integer.parseInt(st.nextToken());
		int dongLoc = Integer.parseInt(st.nextToken());
		
		int dong = findDist(dongDir, dongLoc);
		
		int answer = 0;
		
		
		for (int s = 0; s < store; s++) {
			int max = Math.max(dong, storeArr[s]);
			int min = Math.min(dong,storeArr[s]);
			answer += Math.min((max-min), (2*n + 2*m -max+min));
//			System.out.println(Math.min((max-min), (2*n + 2*m -max+min)));
		}
		
		System.out.println(answer);
		

	}

	private static int findDist(int dir, int loc) {
		int distance = 0;

		if (dir == 1) {
			distance = loc;
		} else if (dir == 4) {
			distance = n + loc;
		} else if (dir == 2) {
			distance = n + m + (n-loc);
		} else if (dir == 3) {
			distance = n + m + n + (m-loc);
		}

		return distance;
	}
}
