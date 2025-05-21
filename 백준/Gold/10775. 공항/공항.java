import java.util.*;
import java.io.*;

public class Main {
    
    static int g,p;
    static int[] parent;
    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        g = Integer.parseInt(br.readLine());
        p = Integer.parseInt(br.readLine());
        
        parent = new int[g+1];
        
        for (int i = 0; i < g+1; i++) {
            parent[i] = i;
        }
        
        int answer = 0;
        for (int i= 0; i < p; i++) {
            int gi = Integer.parseInt(br.readLine());
            int gate = find(gi);
            if (gate == 0) break;
            
            answer++;
            union(gate, gate-1);
        }
        
        System.out.println(answer);
        
    }
    
    private static int find(int x) {
        if (parent[x] == x) {
            return x;   
        }
        
        parent[x] = find(parent[x]);
        
        return parent[x];
    }
    
    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        
        parent[x] = y;
    }
    
}
