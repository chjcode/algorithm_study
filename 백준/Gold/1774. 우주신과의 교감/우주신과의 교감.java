import java.io.*;
import java.util.*;

public class Main {
    
    static class Node implements Comparable<Node>{
        int u;
        int v;
        double cost;
        Node(int u, int v, double cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node n) {
            return Double.compare(this.cost, n.cost);
        }
    }
    
    static int[] parent;
    static int[] rank;
    
    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    
    static boolean union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        
        if (xRoot != yRoot) {
            parent[yRoot] = xRoot;
            return true;
        }
        
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        double[] x = new double[n+1];
        double[] y = new double[n+1];
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        
        parent = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }
        
        List<Node> lst = new ArrayList<>();
        for (int i = 1; i < n+1; i++) {
            for (int j = i+1; j < n+1; j++) {
                double dx = x[i] - x[j];
                double dy = y[i] - y[j];
                double dist = Math.sqrt(dx * dx + dy * dy);
                lst.add(new Node(i,j,dist));
            }
        }
        
        Collections.sort(lst);
        
        double answer = 0.0;
        for (Node node : lst) {
            if (union(node.u, node.v)) {
                answer += node.cost;
            }
        }
        
        System.out.printf("%.2f", answer);
        
    }
        
}
