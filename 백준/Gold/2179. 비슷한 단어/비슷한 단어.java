import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static List<String> words;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		words = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			words.add(br.readLine());
		}
		
		int maxLen = 0;
		int firstIdx = 0;
		int secondIdx = 0;
		
		for (int i = 0; i < words.size(); i++) {
			for (int j = i+1; j < words.size(); j++) {
				if ((!words.get(i).equals(words.get(j)))) {
					// 두 단어 비교
					int cnt = 0; 
					for (int a = 0; a < Math.min(words.get(i).length(), words.get(j).length()); a++) {
						if (words.get(i).charAt(a) != words.get(j).charAt(a)) {
					        break;
					    }
						cnt++;
					}
					
					if (cnt > maxLen) {
						maxLen = cnt;
						firstIdx = i;
						secondIdx = j;
					}
				}
			}
		}
		
		System.out.println(words.get(firstIdx));
        System.out.println(words.get(secondIdx));

	}

}
