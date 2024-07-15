
import java.util.*;
import java.io.*;
public class Main {

    static int n,m,answer;
    static int[][] graph;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];

        for (int i = 0; i < n; i++){
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0,0);

        System.out.println(graph[n-1][m-1]-1);
    }

    public static void bfs(int a, int b){
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(a,b));
        graph[a][b] = 2;

        while (!que.isEmpty()){
            Point point = que.remove();
            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if (nx < 0 || nx > (n-1) || ny < 0 || ny > (m-1)){
                    continue;
                }
                if (graph[nx][ny] == 1){
                    graph[nx][ny] = graph[point.x][point.y] + 1;
                    que.add(new Point(nx,ny));
                }
            }
        }

    }
}

