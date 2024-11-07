import java.util.*;
import java.io.*;

public class Main {

	static int x,y;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();		
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < t; tc++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			// 도착하기 바로 직전의 이동거리는 1광년 -> 도착하기 전부터 계속해서 줄어야함
			int distance = y-x;
			int sqrtDist = (int) Math.sqrt(distance);
			
			if (distance == sqrtDist * sqrtDist) {
				sb.append(2*sqrtDist-1).append("\n");
			} else if (distance <= sqrtDist * sqrtDist + sqrtDist) {
				sb.append(2*sqrtDist).append("\n");
			} else {
				sb.append(2*sqrtDist + 1).append("\n");
			}
			
		}
		
		System.out.println(sb);
		
	}

}
