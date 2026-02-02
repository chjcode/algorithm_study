import java.util.*;
import java.io.*;

public class Main {
    
    static List<List<Integer>> tree;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        st.nextToken();
        for (int i = 1; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            
            tree.get(parent).add(i);
        }
        
        System.out.println(dfs(0));
        
    }
    
    static int dfs(int parent) {
        List<Integer> times = new ArrayList<>();
        
        for (int child : tree.get(parent)) {
            times.add(dfs(child));
        }
        
        times.sort(Collections.reverseOrder());

        int result = 0;
        for (int i = 0; i < times.size(); i++) {
            result = Math.max(result, times.get(i) + (i + 1));
        }
        return result;
    }
}