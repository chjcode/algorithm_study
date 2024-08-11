
import java.util.*;
import java.io.*;

public class Main {
    static int n,m,robotX,robotY,d,cnt;
    static int[][] graph;
    static int[] dx = {-1,0,1,0};   //북,동,남,서
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
//        현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
//        현재 칸의 주변
//        4칸 중 청소되지 않은 빈 칸이 없는 경우,
//        바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
//        바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
//        현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,반시계 방향으로 90도회전한다.
//        바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
//        1번으로 돌아간다.
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        robotX = Integer.parseInt(st.nextToken());
        robotY = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(clean());
    }

    private static int clean() {
        int count = 0;

        while (true) {
            boolean blank = false;
            if (graph[robotX][robotY] == 0) {
                graph[robotX][robotY] = -1;
                count++;
            }
            //2.

            for (int i = 1; i < 5; i++) {
                int nx = robotX + dx[(d-i+4) % 4];
                int ny = robotY + dy[(d-i+4) % 4];
                if (nx < 0 || nx > (n-1) || ny < 0 || ny > (m-1)) {
                    continue;
                }
                if (graph[nx][ny] == 0) {
                    d = (d-i+4) % 4;
                    robotX = nx;
                    robotY = ny;
                    blank = true;
                    break;
                }
            }
            //3. 빈 칸이 없는 경우
//            3-1 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
//            3.2 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
            if (!blank) {
                // 0,1 -> 0,-1 // 1,0 -> -1,0 //
                int nx = robotX - dx[d];
                int ny = robotY - dy[d];

                if (nx < 0 || nx > (n-1) || ny < 0 || ny > (m-1) || graph[nx][ny] == 1) {
                    return count;
                }

                robotX = nx;
                robotY = ny;
            }
        }
    }
}
