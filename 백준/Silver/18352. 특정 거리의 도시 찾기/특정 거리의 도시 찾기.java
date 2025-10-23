import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            graph.get(u).add(v);
        }
        
        int[] visited = new int[n+1];
        
        List<Integer> answer = new ArrayList<>();
        
        Deque<Integer> deq = new ArrayDeque<>();
        deq.addLast(x);
        visited[x] = 1;

        while(!deq.isEmpty()){
            int now = deq.pollFirst();
            
            if (visited[now]-1 == k) {
                answer.add(now);
                continue;
            }
            
            for(int next : graph.get(now)) {
                if(visited[next] == 0) {
                    deq.addLast(next);
                    visited[next] = visited[now] + 1;
                }
            }
        }
        

        
        if (answer.size() > 0) {
            Collections.sort(answer);
        
            for(int a : answer) {
                System.out.println(a);
            } 
        } else {
            System.out.println(-1);
        }
        
    }
}