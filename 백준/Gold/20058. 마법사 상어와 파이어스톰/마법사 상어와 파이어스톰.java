
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int n,q,cntIce,max;
    static int[] l;
    static int[][] graph;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static class Point{
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        graph = new int[(int)Math.pow(2, n)][1<<n];    // 비트연산자로 2^n승

        for (int i = 0; i < 1<<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 1<<n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        l = new int[q];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            l[i] = Integer.parseInt(st.nextToken());
        }

        for(int tc = 0; tc < q; tc++) {
            graph = fireStorm(l[tc]);
            graph = melt();
        }

        // 출력
        cntIce = 0;
        max = 0;
        for(int i = 0; i < 1<<n; i++) {
            for (int j = 0; j < 1<<n; j++) {
                if (graph[i][j] > 0) {
                    max = Math.max(max,bfs(i,j));
                }
            }
        }

        System.out.println(cntIce);
        System.out.println(max);
    }

    public static int bfs(int x, int y){
        Deque<Point> deq = new ArrayDeque<>();
        deq.addLast(new Point(x, y));
        cntIce += graph[x][y];
        graph[x][y] = 0;
        max = 1;
        while (!deq.isEmpty()){
            Point point = deq.pollLast();
            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if (nx < 0 || nx > (1<<n)-1 || ny < 0 || ny > (1<<n)-1){
                    continue;
                }
                if (graph[nx][ny] > 0) {
                    max += 1;
                    cntIce += graph[nx][ny];
                    graph[nx][ny] = 0;
                    deq.addLast(new Point(nx, ny));
                }
            }
        }
        return max;
    }

    public static int[][] melt(){
        // 얼음은 동시에 녹기 때문에 배열 복사 필요
        int[][] temp = new int[1<<n][1<<n];
        // 깊은 복사
        for (int i = 0; i < 1<<n; i++) {
            temp[i] = Arrays.copyOf(graph[i],1<<n);
        }

        for (int x = 0; x < 1<<n; x++) {
            for (int y = 0; y < 1<<n; y++) {
                int cnt = 0;
                if (graph[x][y] == 0) {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx < 0 || nx > (1<<n)-1 || ny <0 || ny > (1<<n)-1) {
                        continue;
                    }
                    if (graph[nx][ny] > 0) {
                        cnt += 1;
                    }
                }
                if (cnt < 3){
                    temp[x][y] -= 1;
                }
            }
        }
        return temp;
    }

    public static int[][] fireStorm(int l) {
        int[][] temp = new int[1<<n][1<<n];
        int scope = 1<<l;   //2^L

        for(int i = 0; i < 1<<n; i+=scope) {
            for(int j = 0; j < 1<<n; j+=scope) {
                rotation(i,j,temp,scope);
            }
        }
        return temp;
    }

    public static void rotation(int x, int y, int[][] temp, int scope) {
        for (int i = 0; i < scope ; i++) {
            for (int j = 0; j < scope; j++) {
                temp[x+j][y+scope-i-1] = graph[x+i][y+j];
            }
        }
    }
}
