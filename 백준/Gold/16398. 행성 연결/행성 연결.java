import java.util.*;
import java.io.*;

public class Main {
    
    static int n;
    static int[] parent;
    
    static class Node implements Comparable<Node> {
        int u;
        int v;
        int cost;
        
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
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        List<Node> lst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if (i < j) lst.add(new Node(i,j,cost));
            }
        }
        
        Collections.sort(lst);
        
        
        long answer = 0;
        int cnt = 0;
        
        for (Node node : lst) {
            if (union(node.u, node.v)) {
                answer += node.cost;
                cnt++;
                if (cnt == n-1) break;
            }
        }
        
        System.out.println(answer);
        
        
    }
    
    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        
        return parent[x] = find(parent[x]);
    }
    
    private static boolean union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        
        if (xRoot != yRoot) {
            parent[yRoot] = xRoot;
            return true;
        }
        
        return false;
    }
}