import java.util.*;
import java.io.*;

public class Main {

    static class City implements Comparable<City> {
        int v;
        int cost;
        City (int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(City c) {
            return this.cost - c.cost;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        List<List<City>> lst = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            lst.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            lst.get(u).add(new City(v,c));
        }
        
        
        
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.add(new City(start, 0));
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        while(!pq.isEmpty()) {
            City now = pq.poll();
            
            if (dist[now.v] < now.cost) continue;
            
            for (City next : lst.get(now.v)) {
                if (dist[next.v] > dist[now.v] + next.cost) {
                    dist[next.v] = dist[now.v] + next.cost;
                    pq.add(new City(next.v, dist[next.v]));
                }
            }
        }
        
        System.out.println(dist[end]);
        
    }
}