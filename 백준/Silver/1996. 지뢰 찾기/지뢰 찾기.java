import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        StringBuilder sb = new StringBuilder();
        int[][] cnt = new int[n][n];
        int[] dx = {0,-1,-1,-1,0,1,1,1};
        int[] dy = {-1,-1,0,1,1,1,0,-1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                if (arr[i][j] != '.') {
                    sb.append('*');
                    continue;
                }
                
                for (int k = 0; k < 8; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k]; 
                    if (nx < 0 || nx > (n-1) || ny < 0 || ny > (n-1)) continue;
                    if (arr[nx][ny] != '.') {
                        sum += arr[nx][ny] - '0';
                    }
                }
                
                if (sum < 10) {
                    sb.append(sum);
                } else {
                    sb.append('M');
                }

            }
            sb.append('\n');
        }
        
        System.out.println(sb.toString());
        
    }
}