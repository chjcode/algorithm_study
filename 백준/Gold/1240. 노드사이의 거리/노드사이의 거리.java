import java.util.*;
import java.io.*;

public class Main {
    
    static class Node{
        int idx;
        int cost;
        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    
    static int n,m;
    static List<List<Node>> lst;
    static boolean[] visited;
    
    static void find(int now, int end, int sum) {
        if (now == end) {
            System.out.println(sum);
            return;
        }
        
        for (Node next : lst.get(now)) {
            if (!visited[next.idx]) {
                visited[next.idx] = true;
                find(next.idx, end, sum+next.cost);
                visited[next.idx] = false;
            }
            
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        lst = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            lst.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            lst.get(u).add(new Node(v, c));
            lst.get(v).add(new Node(u, c));
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            visited = new boolean[n+1];
            visited[s] = true;
            find(s,e,0);
        }
    }
}