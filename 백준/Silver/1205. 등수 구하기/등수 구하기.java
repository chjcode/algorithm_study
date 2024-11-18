import java.util.*;
import java.io.*;

public class Main {

	static int n,score,p;
	static List<Integer> graph;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		/**
		 * n : 점수 개수
		 * s : 태수 점수
		 * p : 랭킹 리스트에 올라갈 수 있는 점수
		 */
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		score = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		if (n > 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				graph.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		graph.add(score);
		Collections.sort(graph, Comparator.reverseOrder());
		
		//같은 점수가 나온다고해서 무조건 되는게 아님.
		// 같은 점수가 있을 때 맨 마지막꺼가 태수 점수
		// 54322 1
		if (graph.get(n) >= score && p<=n) {
			System.out.println(-1);
		}
		
		else {
			int rank = 1;
			for (int i = 0; i < p; i++) {
				if (graph.get(i) > score) {
					rank++;
				}else {
					break;
				}
			}
			
			System.out.println(rank);
		}
		
	}

}
