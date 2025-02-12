import java.util.*;

class Solution {
    
    static List<List<Integer>> lst;
    static int[] visited;
    
    static class Node implements Comparable<Node>{
        int idx;
        int cnt;
        Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
        
        @Override
        public int compareTo(Node n) {
            return this.cnt - n.cnt;
        }
    }
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];

        visited = new int[n+1];
        lst = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            lst.add(new ArrayList<>());
            visited[i] = Integer.MAX_VALUE;
        }
        
        for (int i =0; i < roads.length; i++) {
            lst.get(roads[i][0]).add(roads[i][1]);
            lst.get(roads[i][1]).add(roads[i][0]);
        }
        
        dijkstra(destination);
        
        for (int i = 0; i < sources.length; i++) {
            
            if (visited[sources[i]] != Integer.MAX_VALUE) {
                answer[i] = visited[sources[i]];
            } else {
                answer[i] = -1;
            }
        }
        
        
        return answer;
    }
    
    public int dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        visited[start] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            
            for (int next : lst.get(node.idx)) {
                // 방문했을 때 기존 값보다 더 작으면 pq에 넣음
                if (node.cnt+1 < visited[next]) {
                    pq.add(new Node(next, node.cnt+1));
                    visited[next] = node.cnt+1;
                }
                
            }
        }
        
        return -1;
    }
}