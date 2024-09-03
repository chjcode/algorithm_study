
import java.util.*;
import java.io.*;

public class Main {
	
	static int v,e,k;
	static List<List<Node>> lst;
	static int[] dist;
	static StringBuilder sb;
	
	static class Node implements Comparable<Node>{
		int end;
		int weight;
		Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node n) {
			return this.weight - n.weight;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());

		lst = new ArrayList<>();
		for (int i = 0; i < v+1; i++) {
			lst.add(new ArrayList<>());
		}
		
		dist = new int[v+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			lst.get(u).add(new Node(v,w));
		}
		
		dijkstra(k);
		sb = new StringBuilder();
		for (int i = 1; i < v+1; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			}else {
				sb.append(dist[i]).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[v+1];		// 해당 정점을 방문하는지 체크할 배열
		pq.add(new Node(start,0));
		dist[start] = 0;	// 출발지에서 최소 거리를 기록할 배열
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();	// pq에서 가장 작은 가중치를 가진 노드를 꺼낸다.
			int curNode = node.end;		// 현재 노드의 번호를 가져온다.
			
			if (visited[curNode] == true) continue;	// 이미 방문한 노드는 건너 뜀
			visited[curNode] = true;			// 현재 노드를 방문 처리
			
			// 현재 노드와 연결된 다음 노드들을 검사
			for (Node nextNode : lst.get(curNode)) {
				if (dist[nextNode.end] > dist[curNode] + nextNode.weight){
					dist[nextNode.end] = dist[curNode] + nextNode.weight;	//최단 거리 갱신
					pq.add(new Node(nextNode.end, dist[nextNode.end]));	// 큐에 갱신된 노드를 추가
				}
			}
		}
	}
}
