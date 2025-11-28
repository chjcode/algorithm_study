import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        
        List<String> lst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (set.contains(str)) {
                lst.add(str);
            }
        }
        
        Collections.sort(lst);
        
        System.out.println(lst.size());
        for (String s : lst) {
            System.out.println(s);
        }
        
    }
}