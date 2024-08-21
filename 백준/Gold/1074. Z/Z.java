
import java.io.*;
import java.util.*;

public class Main {
	static int n, r, c, cnt,answer;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		answer = 0;
		cnt = 0;

		countSeq(r, c, 1<<n);
		
		System.out.println(cnt);
	}

	private static void countSeq(int x, int y, int size) {
		if (size == 1) return;
		
		if (x < size/2 && y < size/2) {		// 1
			countSeq(x,y,size/2);
		}else if (x < size/2 && y >= size/2) {	// 2
			cnt += (size*size/4);
			countSeq(x,y-size/2, size/2);
		}else if (x < size && y < size/2) {	// 3
			cnt += (size*size/4)*2;
			countSeq(x-size/2,y,size/2);
		}else {								// 4
			cnt += (size*size/4)*3;
			countSeq(x-size/2,y-size/2,size/2);
		}
			
	}
}
