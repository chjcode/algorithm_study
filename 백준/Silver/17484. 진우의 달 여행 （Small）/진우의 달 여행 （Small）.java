import java.util.*;
import java.io.*;

public class Main{
    static int n,m,answer;
    static int[][] graph;
    static int[] dx = {1,1,1};
    static int[] dy = {-1,0,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j< m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            dfs(0,j,-2,graph[0][j]);
        }


        System.out.println(answer);
    }

    private static void dfs(int x, int y, int before, int cnt) {

        for (int i = 0; i < 3; i++) {
            if (before == i) continue;

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || ny > (m-1)) {
                continue;
            }

            if (nx > (n-1)){
                answer = Math.min(answer,cnt);
                break;
            }

            dfs(nx,ny,i,cnt+graph[nx][ny]);
        }
    }
}