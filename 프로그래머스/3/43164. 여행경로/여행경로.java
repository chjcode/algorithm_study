import java.util.*;

class Solution {
    
    static int n;
    static boolean[] used;
    static List<String> route;
    
    public String[] solution(String[][] tickets) {

        n = tickets.length;
        used = new boolean[n];
        
        Arrays.sort(tickets, (a,b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        route = new ArrayList<>();
        route.add("ICN");
        
        dfs(0, "ICN", tickets);
        
        return route.toArray(new String[0]);
    }
    
    private boolean dfs(int depth, String now, String[][] tickets) {
        if (depth == n) {
            return true;
        }
        
        for (int i = 0; i < n; i++) {
            if (!used[i] && tickets[i][0].equals(now)) {
                used[i] = true;
                route.add(tickets[i][1]);

                if (dfs(depth+1,tickets[i][1], tickets)) {
                    return true;
                }

                used[i] = false;
                route.remove(route.size() -1);   
                
            }
        }
        
        return false;
    }
}