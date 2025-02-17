import java.util.*;

class Solution {
    
    static class Node{
        int node;
        int cost;
        Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        // n : 마을 개수
        // road : 관계
        // k : 음식 배달ㅇ ㅣ가능한 시간
        // 1번 마을에 있는 음식점이 k 이하의 시간에 배달이 가능한 마을 의 개수 return
        
        List<List<Node>> lst = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            lst.add(new ArrayList<>());
        }
        
        for (int i = 0; i < road.length; i++) {
            int u = road[i][0];
            int v = road[i][1];
            int c = road[i][2];
            lst.get(u).add(new Node(v,c));
            lst.get(v).add(new Node(u,c));
        }
        
        int[] distance = dijkstra(1, lst, N);
        
        for (int i = 1; i < N+1; i++) {
            if (distance[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
    
    private static int[] dijkstra(int start, List<List<Node>> lst, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(new Node(start,0));
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if (distance[now.node] < now.cost) continue;
            
            for (Node next : lst.get(now.node)) {
                if (distance[next.node] > distance[now.node] + next.cost) {
                    distance[next.node] = distance[now.node] + next.cost;
                    pq.add(new Node(next.node, distance[next.node]));
                }
            }
        }
        
        return distance;
    }
}