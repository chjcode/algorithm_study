import java.util.*;
import java.io.*;

public class Main {
	
	static int n,l,d,time;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());	// 안내멘트가 n번 반복 된 후에는 반드시 연결됨
		l = Integer.parseInt(st.nextToken());	// 안내 멘트가 재생되는 시간
		d = Integer.parseInt(st.nextToken());	// 고객이 상담원 연결 요청하는 주기(d초에 1번씩 1초간)
		
		time = n * l + (n-1) * 5;
		int cus = d;

		while (cus <= time) {
			if (cus % (l+5) >= l) {
				break;
			}
			cus += d;
		}
		
		System.out.println(cus);
		
		
	}

}
