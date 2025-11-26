import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        
        String str = br.readLine();
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) {
            arr[i] = str.charAt(i);
        }
        
        // 검은색 b개 이하, 흰색 w개 이상 조건을 만족하는 구간 찾기
        int left = 0;
        int right = -1;
        int wCnt = 0;
        int bCnt = 0;

        int answer = 0;
        while (right < n-1) {
            
            right++;
            if (arr[right] == 'W') {
                wCnt++;
            } else if (arr[right] == 'B') {
                bCnt++;
            }
            
            while(bCnt > b && left <= right) {
                if (arr[left] == 'W') {
                    wCnt--;
                } else if (arr[left] == 'B') {
                    bCnt--;
                }
                left++;
            }
            
            if (wCnt >= w && bCnt <= b) {
                answer = Math.max(answer, right-left+1);
            }
        }
        System.out.println(answer);
    }
}