
import java.util.*;
import java.io.*;

public class Main {
	
	static int n,m;
	static int[] cnt;
	static List<List<Integer>> lst = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// 위상 정렬에 사용할 진입차수 저장 배열 초기화
		cnt = new int[n+1];
		
		// 위상정렬에 사용할 그래프 초기화
		for (int i = 0; i < n+1; i++) {
			lst.add(new ArrayList<>());
		}
		
		// 학생 정보 입력 받기
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// a가 b보다 앞에 와야하니까 
			lst.get(a).add(b);		//a로 b를 탐색하도록 그래프에 저장
			cnt[b]++;				//b의 진입차수 +1;
		}
		
		topologicalSort();
		
		System.out.println(sb.toString());
	}
	
	private static void topologicalSort() {
		Deque<Integer> deq = new ArrayDeque<>();
		
		// 진입차수가 0인 노드 큐에 집어넣기
		for(int i = 1; i < n+1; i++) {
			if (cnt[i] == 0) {
				deq.addLast(i);
			}
		}
		
		while(!deq.isEmpty()) {
			int node = deq.pollFirst();
			
			sb.append(node).append(" ");
			
			// 현재 노드에서 연결된 다른 모든 노드 탐색
			for (int i = 0; i < lst.get(node).size(); i++) {
				cnt[lst.get(node).get(i)]--;	// 인접한 정점의 차수 1 감소
				
				if (cnt[lst.get(node).get(i)] == 0) {	// 진입 차수가 0이 된 정점은 큐에 넣기
					deq.addLast(lst.get(node).get(i));
				}
			}
			
		}
	}

}
