import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        Set<String> s = new HashSet<>();
        for (int i=  0; i < n; i++) {
            s.add(br.readLine());
        }
        
        List<String> lst = new ArrayList<>(s);
        
        Collections.sort(lst, (a,b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            return a.length() - b.length();
        });
        
        for (String str : lst) {
            System.out.println(str);
        }
        
    }
}