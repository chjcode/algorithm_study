import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] sub = new int[n-1];
        st = new StringTokenizer(br.readLine());
        int stack = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n-1; i++) {
            int h = Integer.parseInt(st.nextToken());
            sub[i] = h - stack;
            stack = h;
        }
        
        Arrays.sort(sub);
        
        int result = 0;
        for (int i = 0; i < n-k; i++) {
            result += sub[i];
        }
        
        System.out.println(result);
        
    }
}