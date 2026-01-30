import java.util.*;
import java.io.*;

public class Main {
    
    static int[] parent, rank;
    
    static int find(int x) {
        if (parent[x] == x) return x;
        
        parent[x] = find(parent[x]);
        
        return parent[x];
    }
    
    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX != rootY) {
            parent[rootY] = parent[rootX];
        }

    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        parent = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < n-2; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u,v);
        }
        
        int root = find(1);
        for (int i =2; i < n+1; i++) {
            if (find(i) != root) {
                System.out.println("1 " + i);
                break;
            }
        }
    }
}