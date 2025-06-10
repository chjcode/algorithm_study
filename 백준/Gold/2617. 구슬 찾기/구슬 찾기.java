import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        List<List<Integer>> heavy = new ArrayList<>();
        List<List<Integer>> light = new ArrayList<>();
        
        for (int i = 0; i < n + 1; i++) {
            heavy.add(new ArrayList<>());
            light.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            heavy.get(b).add(a);
            light.get(a).add(b);
        }

        int answer = 0;
        int mid = (n + 1) / 2;
        
        for (int i = 1; i < n+1; i++) {
            boolean[] visited = new boolean[n+1];
            int hCnt = dfs(i, heavy, visited);
            
            visited = new boolean[n+1];
            int lCnt = dfs(i, light, visited);
            
            if (hCnt >= mid || lCnt >= mid) {
                answer++;
            }
        }
        
        System.out.println(answer);
        
    }
    
    private static int dfs(int idx, List<List<Integer>> graph, boolean[] visited) {
        visited[idx] = true;
        int cnt = 0;
        for (int i : graph.get(idx)) {
            if (!visited[i]) {
                cnt++;
                cnt += dfs(i, graph, visited);
            }
        }
        
        return cnt;
    }
}