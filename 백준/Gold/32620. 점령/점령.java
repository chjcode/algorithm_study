import java.util.*;
import java.io.*;

public class Main {
    
    static class Node implements Comparable<Node> {
        int idx;
        int require;
        int acquire;
        
        public Node(int idx, int require, int acquire) {
            this.idx = idx;
            this.require= require;
            this.acquire = acquire;
        }
        
        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.require, n.require);
        }
    }
    
    static int n,m,r;
    static List<List<Integer>> lst;
    static boolean[] visited;
    static int[] a;
    static int[] b;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        
        a = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        b = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        
        lst = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            lst.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            lst.get(u).add(v);
            lst.get(v).add(u);
        }
        
        visited = new boolean[n+1];
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(r,a[r],b[r]));
        
        long answer = 0;
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if (visited[now.idx]) continue;
            
            if (answer < now.require) continue;
            
            visited[now.idx] = true;
            answer += now.acquire;
            
            for (int nextIdx : lst.get(now.idx)) {
                if (!visited[nextIdx]) {
                    pq.add(new Node(nextIdx, a[nextIdx], b[nextIdx]));
                }
            }
        }
        
        System.out.println(answer);
        
    }
    

}

