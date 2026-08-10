import java.util.*;

class Solution {

    List<List<Integer>> lst;
    boolean[] visited;
    int cnt;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        lst = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            lst.add(new ArrayList<>());
        }
        
        for (int[] wire : wires) {
            lst.get(wire[0]).add(wire[1]);
            lst.get(wire[1]).add(wire[0]);
        }
        
        visited = new boolean[n+1];
        for (int[] wire : wires) {
            cnt = 0;
            visited = new boolean[n+1];
            dfs(wire[0], wire[0], wire[1]);
            
            answer = Math.min(answer, Math.abs(cnt - (n-cnt)));
        }
        
        return answer;
    }
    
    private void dfs(int now, int cutA, int cutB) {
        visited[now] = true;
        cnt++;
        
        for (int next : lst.get(now)) {
            
            if ((now == cutA && next == cutB) || (now == cutB && next == cutA)) continue;
            
            if (!visited[next]) {
                dfs(next, cutA, cutB);
            }
        }
    }
}

// import java.util.*;

// class Solution {
    
//     static List<List<Integer>> lst;
    
//     public int solution(int n, int[][] wires) {
//         int answer = Integer.MAX_VALUE;
//         int len = wires.length;
        
//         for (int pass = 0; pass < len; pass++) {
//             lst = new ArrayList<>();
//             for (int i = 0; i <= n; i++) {
//                 lst.add(new ArrayList<>());
//             }

//             for (int i = 0; i < len; i++) {
//                 if (i == pass) continue;
//                 int u = wires[i][0];
//                 int v = wires[i][1];
//                 lst.get(u).add(v);
//                 lst.get(v).add(u);
//             }

//             boolean[] visited = new boolean[n + 1];
//             int cnt = dfs(1, visited);

//             int other = n - cnt;
//             answer = Math.min(answer, Math.abs(cnt - other));
//         }
        
//         return answer;
//     }

//     private int dfs(int node, boolean[] visited) {
//         visited[node] = true;
//         int count = 1;
//         for (int nxt : lst.get(node)) {
//             if (!visited[nxt]) {
//                 count += dfs(nxt, visited);
//             }
//         }
//         return count;
//     }
// }
