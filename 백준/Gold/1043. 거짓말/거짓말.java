import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static Set<Integer> whoKnows = new HashSet<>();
    static int[] parent;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        parent = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            parent[i] = i;
        }
        
        st = new StringTokenizer(br.readLine());
        int knowCnt = Integer.parseInt(st.nextToken());
        for (int i = 0; i < knowCnt; i++) {
            whoKnows.add(Integer.parseInt(st.nextToken()));
        }
        
        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            List<Integer> party = new ArrayList<>();
            
            for (int j = 0; j < cnt; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
            
            for (int j = 0; j < party.size() - 1; j++) {
                union(party.get(j), party.get(j+1));
            }
            
            parties.add(party);
        }
        
        Set<Integer> truthRoots = new HashSet<>();
        for (int person : whoKnows) {
            truthRoots.add(find(person));
        }
        
        int answer = 0;
        for (List<Integer> party : parties) {
            boolean canLie = true;
            
            for (int person : party) {
                if (truthRoots.contains(find(person))) {
                    canLie = false;
                    break;
                }
            }
            
            if (canLie) answer++;
        }
        
        System.out.println(answer);
        
    }
    
    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        
        return parent[x] = find(parent[x]);
    }
    
    static void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        
        if (xRoot != yRoot) {
            parent[yRoot] = xRoot;
        }
    }
}