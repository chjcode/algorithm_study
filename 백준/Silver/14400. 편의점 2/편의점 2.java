import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        int[] idxX = new int[n];
        int[] idxY = new int[n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            idxX[i] = Integer.parseInt(st.nextToken());
            idxY[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(idxX);
        Arrays.sort(idxY);
        
        int x = idxX[n/2];
        int y = idxY[n/2];
        
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += Math.abs((long)idxX[i] - x) + Math.abs((long)idxY[i] - y);
        }
        
        System.out.println(cnt);
        
    }
}