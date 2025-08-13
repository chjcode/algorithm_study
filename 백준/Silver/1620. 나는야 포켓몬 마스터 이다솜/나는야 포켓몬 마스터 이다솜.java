import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        String[] poketmons = new String[n+1];
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 1; i < n+1; i++) {
            String poketmon = br.readLine();
            poketmons[i] = poketmon;
            map.put(poketmon, i);
        }
        
        for (int i = 0; i < m; i++) {
            String temp = br.readLine();
            
            if (temp.charAt(0) >= '0' && temp.charAt(0) <= '9') {
                sb.append(poketmons[Integer.parseInt(temp)]).append('\n');
            } else {
                sb.append(map.get(temp)).append('\n');
            }
        }
        
        System.out.println(sb.toString());
    }
}