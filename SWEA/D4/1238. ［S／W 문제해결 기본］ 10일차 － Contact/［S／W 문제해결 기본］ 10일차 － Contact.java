
import java.io.*;
import java.util.*;

public class Solution {

	static int n,start,from,to,answer;
	static boolean[] visited;
	static List<List<Integer>> lst;
	
	static class Node{
		int x;
		int depth;
		Node(int x, int depth){
			this.x = x;
			this.depth = depth;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc < 11; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			lst = new ArrayList<>();
			for (int i = 0; i < 101; i++) {
				lst.add(new ArrayList<>());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n/2; i++) {
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				
				lst.get(from).add(to);
			}
			
			visited = new boolean[101];
			answer = 0;
			bfs();
			
			System.out.println("#" + tc + " " + answer);
		}

	}
	
	private static void bfs() {
		Deque<Node> deq = new ArrayDeque<>();
		deq.addLast(new Node(start,0));
		visited[start] = true;
		List<Node> nodeLst = new ArrayList<>();
		
		int maxDepth = 0;
		while (!deq.isEmpty()) {
			Node node = deq.pollFirst();
			if (node.depth > maxDepth) {
				nodeLst = new ArrayList<>();
				nodeLst.add(node);
				maxDepth = node.depth;
			}else if (node.depth == maxDepth) {
				nodeLst.add(node);
			}
			for (int next : lst.get(node.x)) {
				if (!visited[next]) {
					visited[next] = true;
					deq.addLast(new Node(next, node.depth+1));
				}
			}
		}
		
		int maxX = 0;
		for (int i = 0; i < nodeLst.size();i++) {
			maxX = Math.max(maxX, nodeLst.get(i).x);
		}
		
		answer = maxX;
	}

}
