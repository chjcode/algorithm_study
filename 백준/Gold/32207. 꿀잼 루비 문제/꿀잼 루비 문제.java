import java.util.*;
import java.io.*;

public class Main{
    
    static class Ruby {
        int x;
        int y;
        int p;
        Ruby(int x, int y, int p) {
            this.x = x;
            this.y = y;
            this.p = p;
        }
    }
    
    static int n,m,k;
    static Ruby[] arr;
    static List<Ruby> lst = new ArrayList<>();
    static int maxValue = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        arr = new Ruby[n*m];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int price = Integer.parseInt(st.nextToken());
                arr[idx++] = new Ruby(i,j,price);
            }
        }
        
        Arrays.sort(arr, (a,b) -> Integer.compare(b.p, a.p));
        
        dfs(0,0,0);
        
        System.out.println(maxValue);
        
        
    }
    
    private static void dfs(int idx, int cnt, int sum) {
        maxValue = Math.max(maxValue, sum);
        
        if (cnt == k) {
            return;
        }
        
        // ⭐ 핵심 수정 부분: 전체 배열이 아닌, 상위 일부만 탐색하도록 범위를 제한한다.
        // arr.length가 50보다 작을 수도 있으므로 Math.min을 사용한다.
        int searchLimit = Math.min(arr.length, 50);
        
        for (int i = idx; i < searchLimit; i++) {
            Ruby now = arr[i];
            boolean flag = false;
            
            for (Ruby next : lst) {
                // 상하좌우인지 체크 -> 거리로 체크하는 신박한 방법
                if (Math.abs(next.x - now.x) + Math.abs(next.y - now.y) == 1) {
                    flag = true;
                    break;
                } 
            }
            
            if (!flag) {
                lst.add(now);
                dfs(i+1, cnt+1, sum+now.p);
                lst.remove(lst.size() -1);
            }
        }
        
    }
}