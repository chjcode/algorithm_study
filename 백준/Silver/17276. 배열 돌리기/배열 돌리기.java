import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int turns = ((d % 360) + 360) % 360 / 45;
            for (int k = 0; k < turns; k++) {
                turn45(arr);
            }
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(arr[i][j]).append(' ');
                }
                sb.append('\n');
            }
        }
        System.out.print(sb.toString());
    }
    
    static void turn45(int[][] a) {
        int n = a.length;
        int mid = n / 2;
        int[][] b = new int[n][n];

        for (int i = 0; i < n; i++) {
            System.arraycopy(a[i], 0, b[i], 0, n);
        }

        for (int i = 0; i < n; i++) {
            b[i][mid] = a[i][i];
            b[i][n - 1 - i] = a[i][mid];
            b[mid][n - 1 - i] = a[i][n - 1 - i];
            b[i][i] = a[mid][i];
        }

        for (int i = 0; i < n; i++) {
            System.arraycopy(b[i], 0, a[i], 0, n);
        }
    }
    
}
