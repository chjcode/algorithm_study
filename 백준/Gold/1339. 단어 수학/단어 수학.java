import java.util.*;
import java.io.*;

public class Main {

	static int n, alphabetLen,answer;
	static List<String> input;
	static Map<Character,Integer> alpha;
	static char[] alphabet;
	static int[] num,order;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		
		input = new ArrayList<>();
		alpha = new HashMap<>();
		for (int i = 0; i < n; i++) {
			//1. 문장 입력 받기
			//2. 문장 입력 받으면서 알파벳을 set으로 입력 받기
			//3. 입력 받은 알파벳에 0~9값을 넣기
			//4. 알파벳의 합 구하기
			// 알파벳을 어떻게 변화시켜가며 다른 숫자로 대응시키지
			String temp = br.readLine();
			input.add(temp);
			for (int j = 0; j < temp.length(); j++) {
				alpha.put(temp.charAt(j),0);
			}
		}
		
		alphabet = new char[alpha.keySet().size()];
		int idx = 0;
		for (char a : alpha.keySet()) {
			alphabet[idx++] = a; 
		}
		
		alphabetLen = alphabet.length;
		num = new int[alphabetLen];
		int tempNum = 9;
		for (int i = 0; i < alphabetLen; i++) {
			num[i] = tempNum--;
		}
		
		answer = 0;
		order = new int[alphabetLen];
		visited = new boolean[alphabetLen];
		alpha = new HashMap<>();
		permutation(0);
		
		System.out.println(answer);
		
	}
	
	private static void permutation(int depth) {
		if (depth == alphabetLen) {			
			int number = 0;
			for (int i = 0; i < alphabetLen; i++) {
				alpha.put(alphabet[i], num[order[i]]);
			}
			
			for (String s : input) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < s.length();i++) {
					sb.append(alpha.get(s.charAt(i)));
				}
				number += Integer.parseInt(sb.toString());
			}
			
			answer = Math.max(answer, number);
			return;
		}

		for (int i = 0; i < alphabetLen; i++) {
			if(visited[i]) {
				continue;
			}
			visited[i] = true;
			order[depth] = i;
			permutation(depth+1);
			visited[i] = false;
		}
	}

}
