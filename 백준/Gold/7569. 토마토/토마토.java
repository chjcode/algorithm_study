
import java.io.*;
import java.util.*;
public class Main {

    static class Point{
        int x;
        int y;
        int h;
        Point(int x, int y, int h){
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
    static int m,n,h,answer;
    static int[][][] graph;
    static int[] dx = {0,0,-1,1,0,0};
    static int[] dy = {-1,1,0,0,0,0};
    static int[] dh = {0,0,0,0,-1,1};
    static Queue<Point> que = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        graph = new int [n][m][h];

        for (int k = 0; k < h; k++){
            for (int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++){
                    graph[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }


        for (int k = 0; k < h; k++){
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    if (graph[i][j][k] == 1){
                        que.add(new Point(i,j,k));
                    }
                }
            }
        }
        answer = 0;
        bfs();
        if (findZero()) {
            System.out.println(answer);
        } else{
            System.out.println(answer);
        }
    }

    static void bfs(){
        while (!que.isEmpty()){
            Point point = que.poll();
            for (int i = 0; i < 6; i++){
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                int nh = point.h + dh[i];
                if (nx < 0 || nx > (n-1) || ny < 0 | ny > (m-1) || nh < 0 || nh > (h-1)) {
                    continue;
                }
                if (graph[nx][ny][nh] == 0){
                    graph[nx][ny][nh] = graph[point.x][point.y][point.h] + 1;
                    answer = Math.max(answer, graph[nx][ny][nh]-1);
                    que.add(new Point(nx,ny,nh));
                }
            }
        }
    }

    static boolean findZero(){
        for (int k = 0; k < h; k++){
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    if (graph[i][j][k] == 0){
                        answer = -1;
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
