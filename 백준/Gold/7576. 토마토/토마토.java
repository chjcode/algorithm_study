import java.util.*;
import java.io.*;

public class Main {

    static int n,m,answer;
    static int[][] graph;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static Queue<Point> que = new LinkedList<>();
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
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        graph = new int[n][m];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (graph[i][j] == 1){
                    que.add(new Point(i,j));
                }
            }
        }
        bfs();
        answer = find();

        System.out.println(answer);
    }

    public static int find(){
        answer = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                answer = Math.max(answer,graph[i][j]);
                if (graph[i][j] == 0){
                    answer = -1;
                    return answer;
                }
            }
        }
        return answer-1;
    }

    public static void bfs(){
        while (!que.isEmpty()){
            Point point = que.remove();
            for (int i = 0; i < 4; i++){
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if (nx < 0 || nx > (n-1) || ny < 0 || ny > (m-1) || graph[nx][ny] == -1) {
                    continue;
                }
                if (graph[nx][ny] == 0){
                    graph[nx][ny] = graph[point.x][point.y] + 1;
                    que.add(new Point(nx,ny));
                }
            }
        }
    }
}
