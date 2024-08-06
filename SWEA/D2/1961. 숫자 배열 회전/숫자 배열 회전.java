
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc < t+1; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] graph = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                StringBuilder sb90 = new StringBuilder();
                StringBuilder sb180 = new StringBuilder();
                StringBuilder sb270 = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb90.append(graph[n-j-1][i]);
                    sb180.append(graph[n-i-1][n-j-1]);
                    sb270.append(graph[j][n-i-1]);
                }
                sb.append(sb90).append(" ").append(sb180).append(" ").append(sb270).append("\n");
            }

            System.out.println("#" + tc);
            System.out.print(sb.toString());
        }
    }
}
