import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] graph = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }
        
        Set<Integer> multitap = new HashSet<>();
        int answer = 0;
        
        for (int i = 0; i < k; i++) {
            int now = graph[i];
            
            if (multitap.contains(now)) continue;
            
            if (multitap.size() < n) {
                multitap.add(now);
                continue;
            }
            
            int remove = -1;
            int removeIdx = -1;
            
            for (int idx : multitap) {
                int next = Integer.MAX_VALUE;
                
                for (int j = i + 1; j < k; j++) {
                    if (graph[j] == idx) {
                        next = j;
                        break;
                    }
                }
                
                if (next > removeIdx) {
                    removeIdx = next;
                    remove = idx;
                }
            }
            
            multitap.remove(remove);
            multitap.add(now);
            answer++;
        }
        
        System.out.println(answer);
    }
}