import java.util.*;
import java.io.*;

public class Main {
    
    static class Node implements Comparable<Node>{
        int idx, cost;
        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.cost, n.cost);
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());
        
        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());    // 방의 개수
            int m = Integer.parseInt(st.nextToken());    // 비밀 통로 개수
            
            List<List<Node>> lst = new ArrayList<>();
            for (int i = 0; i < n+1; i++) {
                lst.add(new ArrayList<>());
            }
            
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                
                lst.get(a).add(new Node(b,c));
                lst.get(b).add(new Node(a,c));
            }
            
            int k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] friends = new int[k];
            for (int i = 0; i < k; i++) {
                friends[i] = Integer.parseInt(st.nextToken());
            }
            
            long[] sumDist = new long[n+1];
            
            for (int i = 0; i < k; i++) {
                int start = friends[i];
                
                int[] dist= new int[n+1];
                boolean[] visited = new boolean[n+1];
                
                Arrays.fill(dist,Integer.MAX_VALUE);
                dist[start] = 0;
                
                PriorityQueue<Node> pq = new PriorityQueue<>();
                pq.add(new Node(start, 0));
                
                while (!pq.isEmpty()) {
                    Node now = pq.poll();
                    
                    if (visited[now.idx]) continue;
                    visited[now.idx] = true;
                    
                    for (Node next : lst.get(now.idx)) {
                        if (dist[next.idx] > dist[now.idx] + next.cost) {
                            dist[next.idx] = dist[now.idx] + next.cost;
                            pq.add(new Node(next.idx, dist[next.idx]));
                        }
                    }

                }
                for (int room = 1; room <= n; room++) {
                    sumDist[room] += dist[room];
                }
            }
            int answer = 1;
            long best = sumDist[1];
                
            for (int room = 2; room < n+1; room++) {
                if (sumDist[room] < best) {
                    best = sumDist[room];
                    answer = room;
                }
            }
                
            System.out.println(answer);
            
        }
        
        
    }
}