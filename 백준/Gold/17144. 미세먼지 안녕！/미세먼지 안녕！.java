
import java.util.*;
import java.io.*;

public class Main {

    static int r,c,t,cleanerUp,cleanerDown;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] graph;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        graph = new int[r][c];
        cleanerUp = -1;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

                if (graph[i][j] == -1 && cleanerUp == -1) {
                    cleanerUp = i;
                    cleanerDown = i+1;
                }
            }
        }


        for (int i = 0; i < t; i++) {
            // 1. 미세먼지 확산
            graph = spread();

            // 2. 공기 순환 및 청정
            clean();
        }

        // 3. 미세먼지 측정
        System.out.println(count());
    }

    private static int[][] spread() {
        int[][] temp = new int[r][c];
        for (int x = 0; x < r; x++) {
            for (int y = 0; y < c; y++) {
                if (graph[x][y] == -1) {
                    temp[x][y] = -1;
                    continue;
                }
                if (0 < graph[x][y]) {
                    temp[x][y] += graph[x][y];
                    for (int i = 0; i < 4; i++) {
                        int dust = graph[x][y]/5;
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                        if (nx < 0 || nx > (r-1) || ny < 0 || ny > (c-1)) continue;

                        if (graph[nx][ny] != -1) {
                            temp[nx][ny] += dust;
                            temp[x][y] -= dust;
                        }
                    }

                }
            }
        }

        return temp;
    }

    private static void clean() {
        //반시계 방향
        //왼쪽
        for (int i = cleanerUp-1; i > 0; i--) {
            graph[i][0] = graph[i-1][0];
        }
        //위쪽
        for(int j = 0; j < c-1; j++) {
            graph[0][j] = graph[0][j+1];
        }
        //오른쪽
        for(int i = 0; i < cleanerUp; i++) {
            graph[i][c-1] = graph[i+1][c-1];
        }
        //아래쪽
        for(int j = c-1; j > 1; j--) {
            graph[cleanerUp][j] = graph[cleanerUp][j-1];
        }
        // 깨끗한 공기
        graph[cleanerUp][1] = 0;

        // 시계 방향
        // 왼쪽
        for (int i = cleanerDown+1; i < r-1; i++) {
            graph[i][0] = graph[i+1][0];
        }
        // 아래쪽
        for (int j = 0; j < c-1; j++) {
            graph[r-1][j] = graph[r-1][j+1];
        }
        // 오른쪽
        for (int i = r-1; i > cleanerDown; i--) {
            graph[i][c-1] = graph[i-1][c-1];
        }
        // 위쪽
        for (int j = c-1; j > 1; j--) {
            graph[cleanerDown][j] = graph[cleanerDown][j-1];
        }
        graph[cleanerDown][1] = 0;
    }

    private static int count() {
        int cnt = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j  < c; j++) {
                if (graph[i][j] > 0) {
                    cnt += graph[i][j];
                }
            }
        }

        return cnt;
    }
}
