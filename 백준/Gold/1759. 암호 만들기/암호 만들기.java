import java.util.*;
import java.io.*;

public class Main {
    
    static int l,c;
    static char[] alpha, answer;
    static boolean[] visited;
    
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        // l개 짜리로 출력
        // c개의 문자
        
        // 그냥 combination돌리면 acc와 같이 중복이 생길 수 있지 않나?
        // 최소 한 개의 모음과 최소 두 개의 모음으로 구성일 때 이거 어떻게?
        alpha = new char[c];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            alpha[i] = st.nextToken().charAt(0);    // st.nextToken()이 어떤 값으로 들어오는거지?
        }
        
        Arrays.sort(alpha);
        answer = new char[l];
        visited = new boolean[c];
        dfs(0, 0);
        
    }
    
    private static void dfs(int depth, int cnt) {
        if (cnt == l) {
            int cntAeiou = 0;
            int cntElse = 0;
            for (int i = 0; i < l; i++) {
                if (check(answer[i])) {
                    cntAeiou++;
                } else {
                    cntElse++;
                }
            }
            
            if (cntAeiou >= 1 && cntElse >= 2) {
                for (int i = 0; i < l; i++) {
                    System.out.print(answer[i]);
                }
                System.out.println();
            }
            return;
        }
        
        for (int i = depth; i < c; i++) {
            answer[cnt] = alpha[i];
            dfs(i+1, cnt+1);
        }
    }
    
    private static boolean check(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}