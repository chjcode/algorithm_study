import java.util.*;
import java.io.*;

public class Main {
    
    static class Applicant {
        int idx;
        int document;    // 서류 순위
        int interview;    // 면접 순위
        Applicant(int idx, int document, int interview) {
            this.idx = idx;
            this.document = document;
            this.interview = interview;
        }
    }
    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());
        
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            
            Applicant[] docu = new Applicant[n];
            
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int document = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                
                docu[i] = new Applicant(i, document, interview);
            }
            
            Arrays.sort(docu, (a, b) -> Integer.compare(a.document, b.document));
            
            int cnt = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (docu[i].interview < min) {
                    cnt++;
                    min = docu[i].interview;
                }
            }
            
            sb.append(cnt).append('\n');

        }
        
        System.out.println(sb.toString());
       
        
        
        
    }
}