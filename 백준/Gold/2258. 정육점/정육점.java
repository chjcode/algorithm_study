import java.util.*;
import java.io.*;

public class Main {
    
    static class Meat implements Comparable<Meat>{
        int w;
        int p;
        Meat(int w, int p) {
            this.w = w;
            this.p = p;
        }
        
        @Override
        public int compareTo(Meat m) {
            if (this.p != m.p) {
                return Integer.compare(this.p, m.p);
            }
            return Integer.compare(m.w, this.w);
        }
    }
    
    static Meat[] meats;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        meats = new Meat[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            meats[i] = new Meat(w,p);
        }
        
        Arrays.sort(meats);
        
        long sumW = 0;    // 지금까지 산 고기 무게(누적합)
        long cnt = 0;    // 현재 가격 p로 산 고기 개수(무게 같은 경우 고려)
        int prevP = -1;    // 직전 고기 무게
        long answer = Long.MAX_VALUE;
        
        for (Meat meat : meats) {
            sumW += meat.w;    // 고기 구매
            if (meat.p == prevP) {
                cnt++;
            } else {
                prevP = meat.p;
                cnt = 1;
            }
            
            if (sumW >= m) {
                long cost = (long) meat.p * cnt;
                answer = Math.min(answer, cost);
            }
        }
        
        System.out.println(answer == Long.MAX_VALUE ? -1 : answer);
        
        
    }
}