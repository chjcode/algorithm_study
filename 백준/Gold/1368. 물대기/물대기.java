import java.util.*;
import java.io.*;

public class Main{
    
    static class Node implements Comparable<Node> {
        int u, v, cost;
        Node(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }
    
    static int[] parent;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        parent = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            parent[i] = i;
        }
        
        int[] cost = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            cost[i] = Integer.parseInt(br.readLine());
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for (int i = 1; i < n+1; i++) {
            pq.add(new Node(0,i,cost[i]));
        }
        
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n+1; j++) {
                int c = Integer.parseInt(st.nextToken());
                if (i != j) {
                    pq.add(new Node(i,j,c));
                }
            }
        }
        
        int total = 0;
        int cnt = 0;
        
        while (!pq.isEmpty() && cnt < n) {
            Node now = pq.poll();
            
            if (union(now.u, now.v)) {
                total += now.cost;
                cnt++;
            }
        }
        
        System.out.println(total);
        
    }
    
    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        
        return parent[x] = find(parent[x]);
    }
    
    public static boolean union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        
        if (xRoot != yRoot) {
            parent[yRoot] = xRoot;
            return true;
        }
        
        return false;
    }
}