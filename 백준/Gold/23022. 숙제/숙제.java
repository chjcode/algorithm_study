import java.util.*;
import java.io.*;

public class Main{
    
    static class Homework {
        int t;
        int v;
        Homework(int t, int v) {
            this.t = t;
            this.v = v;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        // t : 시간
        // y : 숙제 제출 시간
        // v : 벌금 계산용
        // n : 숙제 개수
        // s : 현재 시각
        
        
        int test = Integer.parseInt(br.readLine());
        
        for (int tc = 0; tc < test; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            
            int[] t = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                t[i] = Integer.parseInt(st.nextToken());
            }
            
            int[] v = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                v[i] = Integer.parseInt(st.nextToken());
            }
            
            Homework[] h = new Homework[n];
            for (int i = 0; i < n; i++) {
                h[i] = new Homework(t[i], v[i]);
            }
            
            Arrays.sort(h, (a,b) -> Integer.compare(a.t, b.t));
            
            PriorityQueue<Homework> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.v,a.v));
            
            long answer = 0L;
            long curT = s;
            int idx = 0;
            while (idx < n || !pq.isEmpty()) {
                while (idx < n && (long)h[idx].t <= curT) {
                    pq.add(h[idx++]);
                }
                
                if (pq.isEmpty()) {
                    curT = Math.max(curT, (long)h[idx].t);
                    continue;
                }
                
                Homework now = pq.poll();
                
                answer += (long)now.v * (curT - now.t);
                curT++;
            }
            
            sb.append(answer).append('\n');
            
            
        }
        System.out.println(sb.toString());
        
    }
}