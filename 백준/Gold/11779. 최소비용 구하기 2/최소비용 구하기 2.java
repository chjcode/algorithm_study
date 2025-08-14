import java.util.*;
import java.io.*;

public class Main{
    
    static class Node implements Comparable<Node> {
        int idx;
        int cost;
        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.idx, n.idx);
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, cost));
        }
        
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        int[] prev = new int[n+1];
        
        // 비용이 같다면 최단경로처리는 어떻게 할 것인가?
        // 이 문제는 아무 경로나 출력하면 된다고 하지만, 모두 최단경로로 여겨야하는 문제에서는?
        // 어떻게 해야하는지 추가로 알아보기
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            
            // 현재 노드까지의 비용이 이미 알려진 최소 비용보다 크면 무시
            if (now.cost > dist[now.idx]) continue;
            
            
            for (Node next : graph.get(now.idx)) {
                if (dist[next.idx] > dist[now.idx] + next.cost) {
                    dist[next.idx] = dist[now.idx] + next.cost;
                    prev[next.idx] = now.idx;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }
        
        System.out.println(dist[end]);
        
        // 경로 뒤집기
        List<Integer> path = new ArrayList<>();
        int cur = end;
        while (cur != 0) {
            path.add(cur);
            cur = prev[cur];
        }
        
        Collections.reverse(path);
        
        System.out.println(path.size());
        
        StringBuilder sb = new StringBuilder();
        for (int city : path) {
            sb.append(city).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}