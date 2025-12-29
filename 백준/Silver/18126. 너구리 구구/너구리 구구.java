import java.util.*;
import java.io.*;

public class Main{
    
    static int n;
    static List<List<Node>> lst;
    static boolean[] visited;
    static long answer;
    
    static class Node{
        int idx;
        int cost;
        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        lst = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            lst.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            lst.get(a).add(new Node(b,c));
            lst.get(b).add(new Node(a,c));
        }
        
        visited = new boolean[n+1];
        
        answer = 0;
        
        visited[1] = true;
        dfs(1, 0);
        
        System.out.println(answer);
        
    }
    
    private static void dfs(int now, long dist) {
        if (dist > answer) {
            answer = dist;
        }
        
        for (Node next : lst.get(now)) {
            if (!visited[next.idx]) {
                visited[next.idx] = true;
                dfs(next.idx, dist + next.cost);
                visited[next.idx] = false;
            }    
        }
    }
}