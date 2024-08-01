
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < t+1; tc++) {
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			
			int max = 0;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i<10;i++) {
				int now = Integer.parseInt(st.nextToken());
				if (max < now) {
					max = now;
				}else if (min > now) {
					min = now;
				}
				sum += now;
			}
			
			sum -= min;
			sum -= max;
			int average = Math.round((float) sum / 8);
			
			System.out.printf("#%d %d\n",tc,average);
		}
	}

}
