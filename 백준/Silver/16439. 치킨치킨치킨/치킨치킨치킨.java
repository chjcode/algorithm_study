import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int answer = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = i+1; j < m; j++) {
                for (int k = j+1; k < m; k++) {
                    int sum = 0;
                    
                    for (int p = 0; p < n; p++) {
                        int max = arr[p][i];
                        max = Math.max(max, arr[p][j]);
                        max = Math.max(max, arr[p][k]);
                        sum += max;
                    }
                    
                    if (sum > answer) {
                        answer =sum;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}