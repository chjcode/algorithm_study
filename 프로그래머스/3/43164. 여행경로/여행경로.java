import java.util.*;


class Solution {
    
    static String[] arr;
    static boolean[] visited;
    static int n;
    static boolean flag = false;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        n = tickets.length;
        
        Arrays.sort(tickets, (a,b) -> {
            if (!a[0].equals(b[0])) return a[0].compareTo(b[0]);
            return a[1].compareTo(b[1]);
        });
        
        arr = new String[n+1];
        visited = new boolean[n];  
        

        for(int i = 0; i < n; i++) {
            if (!visited[i] && tickets[i][0].equals("ICN")) {

                arr[0] = tickets[i][0];
                arr[1] = tickets[i][1];
                visited[i] = true;
                dfs(tickets, arr[1], 1);
                if(flag) return arr;
                visited[i] = false;
            }
        }
        

        return arr;
    }
    
    private static void dfs(String[][] tickets, String start, int depth) {
        if (flag) return;
        if (depth == n) {
            flag = true;
            return;
        }

        for(int i = 0; i < n; i++) {
            if (!visited[i] && start.equals(tickets[i][0])) {
                arr[depth+1] = tickets[i][1];
                visited[i] = true;
                dfs(tickets, tickets[i][1], depth+1);
                if(flag) return;
                visited[i] = false;
            } 
        }

    }
}