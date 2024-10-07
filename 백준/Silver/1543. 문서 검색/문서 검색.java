import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String s = br.readLine();
		String w = br.readLine();
		
		s = s.replaceAll(w, "*");
		
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '*') {
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}

}
