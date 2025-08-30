import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int cake = 0;
        int cut = m;
        
        List<Integer> tenP = new ArrayList<>();
        List<Integer> others = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 10) {
                cake++;
            } else if (num % 10 == 0) {
                tenP.add(num);
            } else if (num > 10) {
                others.add(num);
            }
        }
        
        Collections.sort(tenP);
        
        
        for (int len : tenP) {
            if (m <= 0) break;
            
            int piece10 = len/10;
            int tempCut = piece10 - 1;
            
            if (m >= tempCut) {
                m -= tempCut;
                cake += piece10;
            } else {
                cake += m;
                m = 0;
            }
        }
        
        for (int len : others) {
            if (m <= 0) break;
            
            int piece10 = len / 10;
            int tempCut = piece10;
            
            if (m >= tempCut) {
                m -= tempCut;
                cake += piece10;
            } else {
                cake += m;
                m = 0;
            }
        }
        
        System.out.println(cake);
    }
}